---
# try also 'default' to start simple
theme: seriph
colorSchema: dark
# apply any windi css classes to the current slide
class: 'text-center'
# https://sli.dev/custom/highlighters.html
highlighter: shiki
# show line numbers in code blocks
lineNumbers: false
fonts:
  sans: 'Robot'
  serif: 'Robot Slab'
# some information about the slides, markdown enabled
info: |
  ## Slidev Starter Template
  Presentation slides about Mutation Testing with PiTest

  Learn more at [Sli.dev](https://sli.dev)
# persist drawings in exports and build
drawings:
  persist: false
# page transition
transition: slide-left
# use UnoCSS
css: unocss
background: ./assets/xmen.jpeg
---

# Introduction to Mutation Testing

With PiTest.org

<div class="pt-12">
  <span @click="$slidev.nav.next" class="px-2 py-1 rounded cursor-pointer" hover="bg-white bg-opacity-10">
    Press Space for next page <carbon:arrow-right class="inline"/>
  </span>
</div>

<div class="abs-br m-6 flex gap-2">
  <a href="https://github.com/ytvnr/mutation-testing" target="_blank" alt="GitHub"
    class="text-xl slidev-icon-btn opacity-50 !border-none !hover:text-white">
    <carbon-logo-github />
  </a>
</div>

<!--
The last comment block of each slide will be treated as slide notes. It will be visible and editable in Presenter Mode along with the slide. [Read more in the docs](https://sli.dev/guide/syntax.html#notes)
-->

---
transition: fade-out
---

# Unit testing and code coverage

A low code coverages indicates that code is not well tested... so it's maybe unsafe.
So we can say

## And what about high coverage?

```java {all|3|all}
@Test
void fiftyShouldBeInRange() {
  cut.isInRange(50);
}
```

It's pretty easy to improve coverage with tests passing through every line and branch of our code.

> An executed line of code is not a tested one.

---
transition: slide-up
layout: image-right
image: ./assets/mutant.jpeg
---

# What is Mutation Testing?

A good test is a test that fails when he should fail.

Mutation testing automatically modifies existing code in small ways, called mutation, then check if our tests will fail.

If a mutation does not cause at least one test to fail, then it means the test is not written well enough or a test is missing.

---
transition: slide-up
layout: image-right
image: ./assets/kill-em.jpeg
---

# Dead mutant are good mutants

Our goal is to kill all the mutants.

If a Unit Test fails, it means the code modification is detected: **the mutant is killed**.

Else, the mutant survived, meaning it would not be detected if the case occurs in the real world.

<br>

**Mutation killing report coupled with Coverage report provides you the Test Strength**

---
transition: fade-out
layout: fact
---

# PiTest

A state-of-the-art mutation testing system for Java and the JVM

<div class="abs-br m-6 flex gap-2">
  <a href="http://pitest.org/" target="_blank" alt="PiTest.org"
    class="text-xl slidev-icon-btn opacity-50 !border-none !hover:text-white">
    <span> http://pitest.org/ </span>
    <carbon-book />
  </a>
  <a href="https://github.com/hcoles/pitest" target="_blank" alt="PiTest"
    class="text-xl slidev-icon-btn opacity-50 !border-none !hover:text-white">
    <span> https://github.com/hcoles/pitest </span>
    <carbon-logo-github />
  </a>
</div>

---
transition: slide-up
---

# Mutators

- ❓ **CONDITIONAL_BOUNDARIES** - replace relational operator `<, <=, >, >=`
- 📭 **EMPTY_RETURNS** - replaces return values with an ‘empty’ value for that type (e.g. empty strings, empty Optionals, zero for integers)
- ❌ **FALSE_RETURNS** - replaces primitive and boxed boolean return values with false
- ✅ **TRUE_RETURNS** - replaces primitive and boxed boolean return values with true
- 🕳️ **NULL_RETURNS** - replaces return values with null (unless annotated with NotNull or mutable by EMPTY_RETURNS)
- ➕ **INCREMENTS** - replaces increments (++) with decrements (--) and vice versa
- ➖ **INVERT_NEGS** - inverts negation of integer and floating point numbers (e.g. -1 to 1)
- 🧮 **MATH** - replaces binary arithmetic operations with another operation (e.g. + to -)
- ❗️ **NEGATIVE_CONDITIONALS** - negates conditionals (e.g. == to !=)
- 0️⃣ **PRIMITIVE_RETURNS** - replaces primitive return values with 0 (unless they already return zero)
- 🗑️ **VOID_METHOD_CALLS** - removes method calls to void methods

---
transition: slide-up
---

# Configuration

```xml
 <plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>${pitest-parent.version}</version>
  <configuration>
    <targetClasses>
      <param>io.ytvnr.*</param>
    </targetClasses>
    <targetTests>
      <param>io.ytvnr.*</param>
    </targetTests>
  </configuration>
  <dependencies>
    <dependency>
      <groupId>org.pitest</groupId>
      <artifactId>pitest-junit5-plugin</artifactId>
      <version>${pitest-junit5-plugin.version}</version>
    </dependency>
  </dependencies>
</plugin>
```

---
transition: slide-up
layout: image
image: ./assets/kill-the-mutants.jpeg
---

<!-- let's try to seek and destroy the mutants-->

---
transition: fade-out
---

# Interpreting the results

<img border="rounded" src="assets/pit-report.png">

---
transition: fade-out
---

# Interpreting the results

<img border="rounded" src="assets/range-validator-report.png">

---
transition: fade-out
---

# Mutant states

- 💗 **Survived** - The mutant survived the mutator. Test is not written well enough
- 💀 **Killed** - Congratulations! 🎉
- 💀 **No coverage** - Same as Survived, but there was no test exercising the mutated line of code
- 💀 **Non viable** - Mutation that could not be loaded by the JVM as the bytecode is invalid. (PIT tries to minimize it)
- 💀 **Timed out** - May happen if mutator changes the exit condition of loop, making it infinite
- 💀 **Memory error** - Might occur if a mutation increases the amount of memory used by the system.
- 💀 **Run error** - replace relational operator `<, <=, >, >=`

<!--
For RangeValidatorTest

first, just add assertions and run task jacoco
then, add case for 0 (false) and 100 (true)

For Palindrome

just add a case when it's not a palindrome
-->

---
class: px-20
---

# Pros and cons

https://blog.qatestlab.com/2015/08/12/advantages-mutation-testing/

FIXME: Long a executer
FIXME: Selectionner les bonnes classes à tester (éviter lesgetter)

Slidev comes with powerful theming support. Themes can provide styles, layouts, components, or even configurations for tools. Switching between themes by just **one edit** in your frontmatter:

<div grid="~ cols-2 gap-2" m="-t-2">

```yaml
---
theme: default
---
```

```yaml
---
theme: seriph
---
```

<img border="rounded" src="https://github.com/slidevjs/themes/blob/main/screenshots/theme-default/01.png?raw=true">

<img border="rounded" src="https://github.com/slidevjs/themes/blob/main/screenshots/theme-seriph/01.png?raw=true">

</div>

Read more about [How to use a theme](https://sli.dev/themes/use.html) and
check out the [Awesome Themes Gallery](https://sli.dev/themes/gallery.html).

---
preload: false
---

# Animations

Animations are powered by [@vueuse/motion](https://motion.vueuse.org/).

```html
<div
  v-motion
  :initial="{ x: -80 }"
  :enter="{ x: 0 }">
  Slidev
</div>
```

<div class="w-60 relative mt-6">
  <div class="relative w-40 h-40">
    <img
      v-motion
      :initial="{ x: 800, y: -100, scale: 1.5, rotate: -50 }"
      :enter="final"
      class="absolute top-0 left-0 right-0 bottom-0"
      src="https://sli.dev/logo-square.png"
    />
    <img
      v-motion
      :initial="{ y: 500, x: -100, scale: 2 }"
      :enter="final"
      class="absolute top-0 left-0 right-0 bottom-0"
      src="https://sli.dev/logo-circle.png"
    />
    <img
      v-motion
      :initial="{ x: 600, y: 400, scale: 2, rotate: 100 }"
      :enter="final"
      class="absolute top-0 left-0 right-0 bottom-0"
      src="https://sli.dev/logo-triangle.png"
    />
  </div>

  <div
    class="text-5xl absolute top-14 left-40 text-[#2B90B6] -z-1"
    v-motion
    :initial="{ x: -80, opacity: 0}"
    :enter="{ x: 0, opacity: 1, transition: { delay: 2000, duration: 1000 } }">
    Slidev
  </div>
</div>

<!-- vue script setup scripts can be directly used in markdown, and will only affects current page -->
<script setup lang="ts">
const final = {
  x: 0,
  y: 0,
  rotate: 0,
  scale: 1,
  transition: {
    type: 'spring',
    damping: 10,
    stiffness: 20,
    mass: 2
  }
}
</script>

<div
  v-motion
  :initial="{ x:35, y: 40, opacity: 0}"
  :enter="{ y: 0, opacity: 1, transition: { delay: 3500 } }">

[Learn More](https://sli.dev/guide/animations.html#motion)

</div>

---

# LaTeX

LaTeX is supported out-of-box powered by [KaTeX](https://katex.org/).

<br>

Inline $\sqrt{3x-1}+(1+x)^2$

Block
$$
\begin{array}{c}

\nabla \times \vec{\mathbf{B}} -\, \frac1c\, \frac{\partial\vec{\mathbf{E}}}{\partial t} &
= \frac{4\pi}{c}\vec{\mathbf{j}}    \nabla \cdot \vec{\mathbf{E}} & = 4 \pi \rho \\

\nabla \times \vec{\mathbf{E}}\, +\, \frac1c\, \frac{\partial\vec{\mathbf{B}}}{\partial t} & = \vec{\mathbf{0}} \\

\nabla \cdot \vec{\mathbf{B}} & = 0

\end{array}
$$

<br>

[Learn more](https://sli.dev/guide/syntax#latex)

---

# Diagrams

You can create diagrams / graphs from textual descriptions, directly in your Markdown.

<div class="grid grid-cols-3 gap-10 pt-4 -mb-6">

```mermaid {scale: 0.5}
sequenceDiagram
    Alice->John: Hello John, how are you?
    Note over Alice,John: A typical interaction
```

```mermaid {theme: 'neutral', scale: 0.8}
graph TD
B[Text] --> C{Decision}
C -->|One| D[Result 1]
C -->|Two| E[Result 2]
```

```plantuml {scale: 0.7}
@startuml

package "Some Group" {
  HTTP - [First Component]
  [Another Component]
}

node "Other Groups" {
  FTP - [Second Component]
  [First Component] --> FTP
}

cloud {
  [Example 1]
}


database "MySql" {
  folder "This is my folder" {
    [Folder 3]
  }
  frame "Foo" {
    [Frame 4]
  }
}


[Another Component] --> [Example 1]
[Example 1] --> [Folder 3]
[Folder 3] --> [Frame 4]

@enduml
```

</div>

[Learn More](https://sli.dev/guide/syntax.html#diagrams)

---
src: ./pages/multiple-entries.md
hide: false
---

---
layout: center
class: text-center
---

# Learn More

[Documentations](https://sli.dev) · [GitHub](https://github.com/slidevjs/slidev) · [Showcases](https://sli.dev/showcases.html)

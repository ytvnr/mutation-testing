# mutation-testing
Materials to present Mutation testings principles

## Use cases

Go in See [Java sources](./mutation-testing-src)

```shell
cd ./mutation-testing-src
```

A https://taskfile.dev/ is provided to quickly generate:
- Jacoco report: `task jacoco`, it will clean install the project and generate the report under `target/site`
- PiTest report: `task mutate`, it will generate the pitest report under `pit-reports`

## Solution

You can find the solutions to have a **100% Test Strength** on branch `fix-tests-for-max-test-strength`

## Slides

Uses https://sli.dev/guide/install.html#starter-template.

### Run it

We use yarn to run the slides. Make sure your node version is >14.
See [Slides README](./mutation-testing-slides/README.md)

- Go inside [mutation-testing-slides](./mutation-testing-slides)
- Run `yarn slidev` or `yarn dev` (it will open the presentation in your browser)

### Share in IntelliJ

Thanks to [Presentation HTML file](./mutation-testing-slides/presentation.html), you can present your slides directly from IntelliJ

- Run Slidev as mentioned [here](#run-it)
- Open [presentation.html](./mutation-testing-slides/presentation.html) in IntelliJ
- Choose the built-in preview 

  ![Built-In Preview](docs/imgs/builtin-preview.png)

- And here is the result:

  ![Built-In Preview Result](docs/imgs/builtin-preview-result.png)

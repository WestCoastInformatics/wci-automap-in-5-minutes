<a name="top"></a>

AUTOMAP REGENERATE CLIENT SDKs
==================================
This is a how-to guide for rebuilding openapi generated code as updates to the swagger are implemented.

## Requirements

1. Java 17+

## How to Build a Single Client

If you need to regenerate a single client for a given language:

1. Open your terminal and cd to the dir. e.g. `automap-in-5-minutes/doc/code-generator`
2. Execute `./gradlew <nameOfTask>` in your terminal
3. The code will generate in a `build` dir. Navigate to the `build` dir.
4. From the `build` dir, copy the generated code files and any other files required to build the project to the
   corresponding "examples" folder.
    1. See [next steps](#tasks-to-regenerate-code--next-steps) for details based on your language generated

**[Back to top](#top)**

## How to Build All Clients

If you need to rebuild all the clients for all languages, typically after a big update to the `.yaml` file or
swagger documentation url:

1. Open your terminal and cd to the project directory. e.g. `automap-in-5-minutes/doc/code-generator`
2. Execute `./gradlew buildClients`
3. All generated projects will be in a `build` folder. Navigate to the `build` folder to see the generated code
4. From the `build` folder, copy the generated code files and additional files needs to build/compile the project to the
   corresponding examples folder.
    1. See [next steps](#tasks-to-regenerate-code--next-steps) for details

## How to Build Client jar

If you don't need the generated source but only a jar file to use in your project, then follow these steps:

1. Open your terminal and cd to the project directory. e.g. `automap-in-5-minutes/doc/code-generator`
2. Execute `./gradlew makeGeneratedJavaSdkJar`
3. The generated jar will be in the `build/libs` folder
4. The jar file can be used in your project as a dependency either by copying it to your project or by adding it to
   your build tool's dependencies.

**[Back to top](#top)**

## Tasks to Regenerate Code & Next Steps...

The following is a list of the available gradle tasks for each language the openapi code generator can generate. The
location the code is generated to is also provided. Follow the steps for each language on what files to copy to the
corresponding `[language]-examples` directory

### Java client

1. To generate the client code for java, run `./gradlew buildJavaSdk`
2. Find the generated client in `build/java`
3. Copy the new files generated from the `src/main` folder to the `java-examples/src/main` folder.
    1. 🚫🚫 **DO NOT** replace `ApiClient.java`
        1. `java-examples` uses `src/main/resources/url.properties` to set the basePath url in `ApiClient.java`. The url
           should be updated in the `url.properties` file only.
    2. 🚫🚫 **DO NOT** replace tests. Update tests to demo the new api calls or fix failing tests.
4. Verify the gradle files match between what was generated vs what exists in `java-examples`. Update as needed, but
   **don't** override.
5. Verify the project builds and the tests run successfully before pushing changes

**[Back to top](#top)**

## Resources

* https://github.com/int128/gradle-swagger-generator-plugin?tab=readme-ov-file#introduction
* https://stackoverflow.com/questions/66137846/how-to-use-the-open-api-3-gradle-plugin

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Nuno Marques](https://github.com/njmarques)

**[Back to top](#top)**
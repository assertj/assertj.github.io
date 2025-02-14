# AssertJ Doc Website

This project generates and packages the AssertJ documentation website.

This project is based on [Antora](https://antora.org).

As AssertJ is composed of multiple modules, each one host his own documentation source files ( in asciidoc ) and this project is responsible for the aggregation and packaging

## Build documentation

Building AssertJ documentation is done by the all-in-one command :

```
 ./gradlew antora
```

The site is produced in folder `build/site` and you can preview it with any static webserver ( like `python -m SimpleHTTPServer 8000` )

## UI development

This section offers a basic tutorial to teach you how to preview it locally, and bundle it for use with Antora.
A more comprehensive tutorial can be found in the documentation at [docs.antora.org](https://docs.antora.org/).

### Preview the UI

The AssertJ Antora UI sub project is configured to preview offline.
The files in the `preview-src/` folder provide the sample content that allow you to see the UI in action.
In this folder, you'll primarily find pages written in AsciiDoc.
These pages provide a representative sample and kitchen sink of content from the real site.

To build the UI and preview it in a local web server, run the `preview` command:

```
./gradlew previewUI
```

You'll see a URL listed in the output of this command:

```
[12:00:00] Starting server...
[12:00:00] Server started http://localhost:5252
[12:00:00] Running server
```

Navigate to this URL to preview the site locally.

While this command is running, any changes you make to the source files will be instantly reflected in the browser.
This works by monitoring the project for changes, running the `preview:build` task if a change is detected, and sending the updates to the browser.

Press `Ctrl`+`C` to stop the preview server and end the continuous build.

### Package for Use with Antora

```
./gradlew buildUI
```

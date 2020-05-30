[![JetBrains IntelliJ Plugins](https://img.shields.io/jetbrains/plugin/v/12407-usd.svg?style=popout)](https://plugins.jetbrains.com/plugin/12407-usd)
[![JetBrains IntelliJ plugins](https://img.shields.io/jetbrains/plugin/d/12407-usd.svg?style=popout)](https://plugins.jetbrains.com/plugin/12407-usd)

# usd-idea

A plugin for JetBrains IDEs (PyCharm, IntelliJ, etc) that provides support for [Universal Scene Description (USD)](https://github.com/PixarAnimationStudios/USD), a framework for interchange of 3D computer graphics data, developed by Pixar Animation Studios.

_NOTE_: This plugin is in active development and features are still being implemented. If you're interested in contributing to this project, check out the TODO features below or what's currently open in the [Issues](https://github.com/justint/usd-idea/issues).

## Installing

- Within the IDE:

    <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > Search for "USD" > <kbd>Install</kbd>

- Manually:
    
    Download the [latest release](latest-release) and install it manually using <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Install Plugin from Disk...</kbd>

## Features

- `.usd`/`.usda` filetype syntax highlighting & validation
- Brace matching/folding
- Structure View
    
### TODO:

- [Binary USD file support](https://github.com/justint/usd-idea/issues/7)
- [Language tests](https://www.jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html)
- Reference Contributor
  - "Go to definition/symbol" feature implementation
  - "Find Usages" provider
- Line markers for overrides, inheritance, etc

## Building

1. [Install IntelliJ IDEA](https://www.jetbrains.com/idea/download); install **Gradle** and **Plugin Devkit** plugins (installed by default)
2. Open this project
3. Build the project: <kbd>Build</kbd> > <kbd>Build Project</kbd>
4. Launch the plug-in: <kbd>Gradle</kbd> > <kbd>usd-idea</kbd> > <kbd>Tasks</kbd> > <kbd>intellij</kbd> > <kbd>runIde</kbd>
   
   This will launch the plugin in the IntelliJ IDEA version specified in the [build.gradle](https://github.com/justint/usd-idea/blob/master/build.gradle). 
   
   If you wish to launch it in a different non-IDEA JetBrains IDE (ie. PyCharm, CLion), you can specify an <kbd>alternativeIdePath</kbd> to your editor's path. See the [grade-intellij-plugin](https://github.com/JetBrains/gradle-intellij-plugin/) documentation for more details. 

For more details on building IntelliJ Platform plugins, see JetBrains's documentation: [IntelliJ Platform SDK DevGuide - Quick Start Guide](https://www.jetbrains.org/intellij/sdk/docs/basics/basics.html)

## License

MIT license

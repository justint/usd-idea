![JetBrains IntelliJ Plugins](https://img.shields.io/jetbrains/plugin/v/12407-usd.svg?style=popout)
![JetBrains IntelliJ plugins](https://img.shields.io/jetbrains/plugin/d/12407-usd.svg?style=popout)

# usd-idea

A plugin for JetBrains IDEs (PyCharm, IntelliJ, etc) that provides support for [Universal Scene Description (USD)](https://github.com/PixarAnimationStudios/USD), a file format system developed by Pixar Animation Studios.

_NOTE_: This plugin is in active development and features are still being implemented. If you're interested in contributing to this project, check out the TODO features below or what's currently open in the [Issues](https://github.com/justint/usd-idea/issues).

## Installing

- Within the IDE:

    <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > Search for "USD" > <kbd>Install</kbd>

- Manually:
    
    Download the [latest release](latest-release) and install it manually using <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Install Plugin from Disk...</kbd>

## Features

- `.usd`/`.usda` filetype syntax highlighting & validation
    
TODO:

- [Language tests](https://www.jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html)

- "Go to definition/symbol" feature implementation (Reference Contributor)

- Structure View

- Line markers for overrides, inheritance, etc

- Brace matching

- Python autocompletions for the `pxr.Usd` library

## License

MIT license
# Project description

The goal of the project is help developers to use the [twitter API](https://developer.twitter.com/en)

[![License Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=true)](http://www.apache.org/licenses/LICENSE-2.0)
![minSdkVersion 23](https://img.shields.io/badge/minSdkVersion-23-green?style=true)
![compileSdkVersion 29](https://img.shields.io/badge/compileSdkVersion-29-brightgreen)


## Project characteristics

This project brings to table set of best practices, tools, and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Testing `In progress`
* Dependency Injection
* Static code analyse `In progress`
* CI integration by gihub actions `In progress`

## Tech-stack

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Koin](https://insert-koin.io/) - dependency injection
    * [Retrofit](https://github.com/square/retrofit) Lib used to make call to Twitter API
	* [Timber](https://github.com/JakeWharton/timber) - logging
	* [security-crypto](https://developer.android.com/jetpack/androidx/releases/security) - deal with encrypt content
	* [Test](https://developer.android.com/training/testing/) -  tests
* Architecture
    * Abstract Factory
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
    * [core-testing](https://androidx.tech/artifacts/arch.core/core-testing/) - used to sync background tasks
    * [kotlinx-coroutines-test](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/) - used to sync coroutines jobs
	* [mockk](https://mockk.io/) - mock objects using kotlin's style
* Static code Analyse
    * [Klint](https://ktlint.github.io/#getting-started) - An anti-bikeshedding Kotlin linter with built-in formatter.
* Gradle

## What this project does not cover?

This project cover only the api [standard Search Tweets](https://developer.twitter.com/en/docs/tweets/search/overview/standard). It is expected in the future to implement other API.

 ## Do you want to contribute?

 I'd love if you contribute. Go ahead and give it a try to check our [documentation]()

## Setup

### Create the required twitter.properties file

In order to the library works properly you must create a new file named twitter.properties on root folder with the key baseUrl.

```
// file project/twitter.properties
baseUrl="https://api.twitter.com/"
```

## Gradle 

There are a few ways to open this project.

## Current Version

```gradle
// latest stable
twitterktx_version = '1.0.0-beta-1'
```

### Android Studio

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/thiagoolsilva/twitterKtx` into URL field

### Command-line + Android Studio

1. Run `git clone https://github.com/thiagoolsilva/twitterKtx`

### Importing the lib on Android Studio

1. With your project opened, go to settings.gradle file and insert the follow code
```
include ':twitterktx'
project(":twitterktx").projectDir = new File('TWITTERKTX_FOLDER')
```
2. Finally, go to your preference module and insert the follow code to use the library on it
```
 implementation project(path: ':twitterktx')
```

## Features

This section is related to the features/bug fixes of project.

### Do you want to contribute?

I'd love if you contribute with the upcoming features or bug fixes. Go ahead and read the [CONTRIBUTING](CONTRIBUTING.md) file.

### Upcoming features

You can check it out for new features on [github](https://github.com/thiagoolsilva/twitterKtx/issues?q=is%3Aopen+is%3Aissue+label%3Aupcoming).

## Author

<img src="misc/myAvatar.png" width="40"/>

Follow me

[![Follow me](https://img.shields.io/badge/Medium-thiagoolsilva-yellowgreen)](https://medium.com/@thiagolopessilva)
[![Linkedin](https://img.shields.io/badge/Linkedin-thiagoolsilva-blue)](https://www.linkedin.com/in/thiago-lopes-silva-2b943a25/)
[![Twitter](https://img.shields.io/twitter/follow/thiagoolsilva?style=social)](https://twitter.com/thiagoolsilva)   

## License
```
Copyright (c) 2020  Thiago Lopes da Silva

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
`

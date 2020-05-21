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


## How to use the library


### Config Oauth2 bearer token


1. First of all, you must get a valid oauth2bearer token running the follow `curl` code. 

The INSERT_YOUR_TOKEN_HERE  is a token in base64 composed by consumer key and secret. For more details go to [twitter](https://developer.twitter.com/en/docs/basics/authentication/oauth-2-0)


```
curl -X POST \
  https://api.twitter.com/oauth2/token \
  -H 'authorization: Basic INSERT_YOUR_TOKEN_HERE' \
  -H 'cache-control: no-cache' 
  -H 'content-type: application/x-www-form-urlencoded;charset=UTF-8'
```

It will return something like this:

```
{
    "token_type": "bearer",
    "access_token": "your_oauth2_token"
}

```
 
2. Init the twitterKtx

There are two approach to do it on Application class.

1. If you Koin as your dependency inject, you must use the code `TwitterKtx.initKoinDependencies()` after call `startKoin{}` on onCreate function.

```
 override fun onCreate() {
    startKoin{
        ...
    }
    TwitterKtx.initKoinDependencies()
 }
```

You can check it out this code on [Application](https://github.com/thiagoolsilva/twitterKtx/blob/master/example/app/src/main/java/br/tls/sample/Application.kt)


2. If you don't use Koin as your dependency inject, you must use the code `TwitterKtx.init(this@Application)` on onCreate function.

```
override fun onCreate() {
    super.onCreate()
    TwitterKtx.init(this@Application)
 }

```

You can check it out this code on [Application](https://github.com/thiagoolsilva/twitterKtx/blob/master/example-withou-di/app/src/main/java/br/tls/myapplication/Application.kt)

 

4. Provide the token to library calling the function ` TwitterKtx.configToken(tokenAuth)`

For more details about it you can go to [FirstFragment](https://github.com/thiagoolsilva/twitterKtx/blob/feature_crypto_readme/example/app/src/main/java/br/tls/sample/mainsample/FirstFragment.kt)


5. As the library uses coroutines, you must create a coroutine context to use it. In order to exemplify you can do it on Fragment as shown below.

```
viewModelScope.launch {

        ...
}
```

Don't forget to get the library `implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$2.3.0-alpha02"`


6. Create a new instance of API library

```
 val standardSearchTweet = SearchTweetFactory().createStandardApi<StandardSearchTweetV1>(SearchTweetFactory.ApiType.V1)
 ```

7. Call the API providing the required and optional parameters.

```
val tweets = standardSearchTweet.searchTweet(
                    query, mutableListOf(
                        StandardSearchTweetV1Api.COUNT to 20
                    )
                )
```

8. Get the results. Happy coding! :D

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

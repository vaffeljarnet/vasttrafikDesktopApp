# Java 8 Västtrafik Desktop App

Exploratory personal project created long ago to learn how to work with with REST APIs.

* A working runnable jar can be downloaded from here [Studio Tumult](http://studiotumult.blogspot.se/p/programingit.html)

## How to run
There are som small changes that will make it possible to run. First off, a Västtrafik developer account [needs to be registered](https://developer.vasttrafik.se/portal/#/) and approved. When able to log in, a new application needs to created, and finally a subscription to "Reseplaneraren v2" API needs to be set. A guide can be [found here](https://developer.vasttrafik.se/portal/#/guides/get-started).

When an application is set up it's possible to generate keys for the application. Theese keys can then be inserted as Strings in the method generateAcessToken() in the class src.auth.AccessTokenHandler where I've commented on where to insert what. More info can be found in Västtrafiks [Oauth2 guide](https://developer.vasttrafik.se/portal/#/guides/oauth2).

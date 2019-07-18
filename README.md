Available via [clojars](https://clojars.org/file-atlas)   
Current stable version: [file-atlas "1.0.0"]


# File Atlas

A Clojure library designed to allow you to easily mmap files via Java's NIO, and to handle files larger than 2GB. This is based on the [clj-mmap](https://github.com/thebusby/clj-mmap)


## Usage
```clojure
(with-open [mapped-file (file-atlas/get-mmap "/tmp/big_file.txt")]
  (let [some-bytes (file-atlas/get-bytes mapped-file 0 30)]
    (println (str "First 30 bytes of file, '" (String. some-bytes "UTF-8") "'"))))
```


## Artifacts

file-atlas artifacts are [released to Clojars](https://clojars.org/file-atlas).

If you are using Maven, add the following repository definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

    [file-atlas "1.0.0"]


With Maven:

    <dependency>
      <groupId>file-atlas</groupId>
      <artifactId>file-atlas</artifactId>
      <version>1.0.0</version>
    </dependency>


## License

MIT
http://opensource.org/licenses/MIT

I'd also like to thank my employer, Gracenote, for allowing me to create this open source port.

Copyright (C) 2012-2013 Alan Busby

Some contributions Copyright (C) 2019 Rebecca Pruim

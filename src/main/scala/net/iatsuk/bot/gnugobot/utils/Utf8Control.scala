package net.iatsuk.bot.gnugobot.utils

import java.io.InputStreamReader
import java.util.ResourceBundle.Control
import java.util.{Locale, PropertyResourceBundle, ResourceBundle}

/**
  * Custom [[ResourceBundle.Control]] implementation wherein explicitly read the properties files as UTF-8 using
  * [[InputStreamReader]].
  *
  * @see https://stackoverflow.com/a/4660195/6380624
  */
class Utf8Control extends Control {

  override def newBundle(baseName: String, locale: Locale, format: String, loader: ClassLoader, reload: Boolean): ResourceBundle = {
    // The below is a copy of the default implementation.
    val bundleName = toBundleName(baseName, locale)
    val resourceName = toResourceName(bundleName, "properties")
    var bundle: ResourceBundle = null

    val stream = if (reload) {
      Option(loader.getResource(resourceName))
        .flatMap(url => Option(url.openConnection()))
        .map { connection =>
          connection.setUseCaches(false)
          connection.getInputStream
        }
    } else {
      Option(loader.getResourceAsStream(resourceName))
    }

    if (stream.isDefined) {
      try {
        // Only this line is changed to make it to read properties files as UTF-8.
        bundle = new PropertyResourceBundle(new InputStreamReader(stream.get, "UTF-8"))
      } finally {
        stream.get.close()
      }
    }
    bundle
  }
}

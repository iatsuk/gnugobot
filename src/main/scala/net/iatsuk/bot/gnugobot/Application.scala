/*
 * GnuGoBot  Copyright (C) 2018  Andrei Iatsuk <hi@yatsukav.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.iatsuk.bot.gnugobot

import java.util.{Locale, ResourceBundle}

import net.iatsuk.bot.gnugobot.utils.Utf8Control

object Application extends App {
  val eng = ResourceBundle.getBundle("lang", Locale.ROOT, new Utf8Control)
  val rus = ResourceBundle.getBundle("lang", Locale.forLanguageTag("ru"), new Utf8Control)
  println(eng.getString("greeting"))
  println(eng.getString("choose_lang"))
  println(rus.getString("greeting"))
  println(rus.getString("choose_lang"))
}

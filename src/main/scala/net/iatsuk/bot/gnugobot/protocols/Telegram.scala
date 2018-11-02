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
package net.iatsuk.bot.gnugobot.protocols

import info.mukel.telegrambot4s.api.declarative.Commands
import info.mukel.telegrambot4s.api.{Polling, TelegramBot}

import scala.io.Source

object Telegram extends TelegramBot with Polling with Commands {

  lazy val token: String = scala.util.Properties
    .envOrNone("BOT_TOKEN")
    .getOrElse(Source.fromFile("bot.token").getLines().mkString)
  onCommand('hello) { implicit msg => reply("My token is work!") }
}

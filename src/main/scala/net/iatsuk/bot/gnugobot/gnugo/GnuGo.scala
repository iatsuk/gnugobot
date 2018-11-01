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
package net.iatsuk.bot.gnugobot.gnugo

import java.io.PrintWriter

import net.iatsuk.bot.gnugobot.gnugo.GnuGoCmd.Dot

import scala.io.Source

class GnuGo {

  private var process: Process = _
  private var sender: PrintWriter = _
  private var receiver: Source = _


  def move(isAiBlack: Boolean, historyCmd: Seq[GnuGoCmd.Cmd]): Dot = ???

  private def start(): Unit = {
    if (isWork) {
      process = new ProcessBuilder()
        .command("./gnugo", "--mode", "gtp")
        .start()

      sender = new PrintWriter(process.getOutputStream)
      receiver = Source.fromInputStream(process.getInputStream)
    }
  }

  private def send(msg: Seq[String]): Iterator[String] = {
    if (isWork) start()
    for (m <- msg) sender.println(m)
    sender.flush()
    Thread.sleep(100L)
    receiver.getLines()
  }

  private def stop(): Unit = {
    if (isWork) {
      process.destroy()
      process.waitFor()
    }
  }

  def isWork: Boolean = process != null && !process.isAlive
}

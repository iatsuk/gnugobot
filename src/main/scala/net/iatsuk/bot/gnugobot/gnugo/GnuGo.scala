/*
 * GnuGoBot  Copyright (C) 2018  Andrei Iatsuk (hi@yatsukav.com)
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

import java.io.{File, PrintWriter}

import scala.io.Source

class GnuGo {

  private var process: Process = _
  private var sender: PrintWriter = _
  private var receiver: Source = _

  def start(): Unit = {
    process = new ProcessBuilder()
      .command("./gnugo", "--mode", "gtp")
      .directory(new File("src/main/resources/"))
      .redirectError(new File("error.txt"))
      .redirectOutput(new File("output.txt"))
      .start()

    sender = new PrintWriter(process.getOutputStream)
    receiver = Source.fromInputStream(process.getInputStream)
  }

  def send(msg: String): Iterator[String] = {
    sender.println("boardsize 7")
    sender.println("black a1")
    sender.println("black a0")
    sender.println("black a2")
    sender.println("showboard")
    sender.flush()
    Thread.sleep(100L)
    receiver.getLines()
  }

  def stop(): Int = {
    process.destroy()
    process.waitFor()
    process.exitValue()
  }
}

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
package net.iatsuk.bot.gnugobot

import java.io.{File, PrintWriter}

object Application extends App {
  val license =
    """BlindGoBot  Copyright (C) 2018  Andrei Iatsuk (hi@yatsukav.com)
      |This program comes with ABSOLUTELY NO WARRANTY.
      |This is free software, and you are welcome to
      |redistribute it under certain conditions.
      |See https://www.gnu.org/licenses/ for details.""".stripMargin
  println(license)

  val runtime = Runtime.getRuntime
  val process = new ProcessBuilder()
    .command("./gnugo", "--mode", "gtp")
    .directory(new File("src/main/resources/"))
    .redirectError(new File("error.txt"))
    .redirectOutput(new File("output.txt"))
    .start()

  val pw = new PrintWriter(process.getOutputStream)
  pw.println("boardsize 7")
  pw.println("black a1")
  pw.println("black a0")
  pw.println("black a2")
  pw.println("showboard")
  pw.flush()
  Thread.sleep(100L)

  process.destroy()
  process.waitFor()
  println(process.exitValue())
}

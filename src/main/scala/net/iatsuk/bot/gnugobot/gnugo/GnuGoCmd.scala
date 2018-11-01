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

object GnuGoCmd {

  type Dot = (Color, Byte)

  sealed abstract class Color(val name: String) { override def toString: String = name }
  case object Black extends Color("black")
  case object White extends Color("white")
  case object Empty extends Color("empty")

  sealed abstract class Cmd(val cmd: String) { override def toString: String = cmd}
  case object Quit extends Cmd("quit")
  case class BoardSize(size: Int) extends Cmd("boardsize") { override def toString = s"$cmd $size" }
  case object ClearBoard extends Cmd("clear_board")
  case class B(dot: Dot) extends Cmd("black") { override def toString = s"$cmd ${dot._1}${dot._2}" }
  case class W(dot: Dot) extends Cmd("white") { override def toString = s"$cmd ${dot._1}${dot._2}" }
  case class WhatOn(dot: Dot) extends Cmd("color") { override def toString = s"$cmd ${dot._1}${dot._2}" }
  case object History extends Cmd("move_history")
  case object GenB extends Cmd("genmove_black")
  case object GenW extends Cmd("genmove_white")
  case class Level(level: Int) extends Cmd("level") { override def toString = s"$cmd $level" }
  case object Undo extends Cmd("undo")
  case object Score extends Cmd("final_score")
  case object Pass extends Cmd("")
}

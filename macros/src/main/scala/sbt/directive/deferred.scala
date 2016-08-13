package directive

trait DeferredTransformer[T] {
  def source: String
}

import scala.reflect.macros.Context

object DeferredContext {
  def deferred_line_process(c: Context)(t: c.Expr[List[String] => List[String]]): c.Expr[Int] = {
    import c.universe._
  
    println(t.tree)
    ???
  }
}

import scala.language.experimental.macros

object Preprocess {
  def lines(t: List[String] => List[String]): Int =
    macro DeferredContext.deferred_line_process
}

package directive

import sbt._
import Keys._

object DirectivePlugin extends AutoPlugin {
  object autoImport {
    val directiveSettings = Seq( 
      DirectiveKeys.directive := Directive().value,
      (sourceGenerators in Compile) <+= DirectiveKeys.directive,
      libraryDependencies ++= Seq(
        "org.scalameta" %% "scalameta" % "1.0.0"
      )
    )
  }
}

object DirectiveKeys {
  val directive: TaskKey[Seq[File]] = taskKey("Preprocesses directives")
}



object Test {

  Preprocess.lines { ls =>
    Set("1")
    List(1, 2, 3)
    Vector(1)
    Seq("a")
    DirectiveKeys.directive
    val s: String = "asd"
    val t: Int = 42
    ???
  }

}

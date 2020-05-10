import sbt._

object Dependencies {
  // versions
  lazy val sparkVersion = "2.4.5"
  lazy val hadoopVersion = "2.9.2"
  lazy val awsSdkVersion = "2.9.20"

  // testing
  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.7" % "test,it"

  // arc
  val arc = "ai.tripl" %% "arc" % "2.11.0" % "provided"

  // spark
  val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"

  val tika = "org.apache.tika" % "tika-parsers" % "1.19.1"
  val sqlite_jdbc = "org.xerial" % "sqlite-jdbc" % "3.25.2"

  // Project
  val etlDeps = Seq(
    scalaTest,
    
    arc,

    sparkSql,

    tika,
    sqlite_jdbc
  )
}
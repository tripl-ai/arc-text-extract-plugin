package ai.tripl.arc.plugins.udf

import scala.util.Try

import org.apache.spark.sql.SparkSession

import ai.tripl.arc.api.API.ARCContext
import ai.tripl.arc.util.ControlUtils._
import ai.tripl.arc.util.Utils
import ai.tripl.arc.util.log.logger.Logger

class DocumentTextExtractUDFPlugin extends ai.tripl.arc.plugins.UDFPlugin {

  val version = Utils.getFrameworkVersion

  override def register()(implicit spark: SparkSession, logger: Logger, arcContext: ARCContext) = {
    spark.sqlContext.udf.register("parseText", (raw: Array[Byte]) => DocumentTextExtractUDF.parseTika(raw))
    spark.sqlContext.udf.register("parseTika", (raw: Array[Byte]) => DocumentTextExtractUDF.parseTika(raw))
  }

}

object DocumentTextExtractUDF {

  def parseTika(content: Array[Byte]): Option[String] = {
    Try {
      val tika = new org.apache.tika.Tika()
      using (new java.io.ByteArrayInputStream(content)) { stream =>
        tika.parseToString(stream)
      }
    }.toOption
  }

}
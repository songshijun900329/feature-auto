package cn.xiaosi.junit.test

import cn.xiaosi.junit.test.beans.Field
import cn.xiaosi.tool.common.utils.{Builder, DateUtils}
import org.junit.jupiter.api.Test

import scala.::

class ToolsTestScala {

  @Test
  def testDateUtil(): Unit = {

    println(DateUtils.transformTimeFormat("16/Dec/2019:17:05:54 +0800", "dd/MMM/uuuu:HH:mm:ss X", "uuuu-MM-dd HH:mm:ss")) //	16/Dec/2019:17:05:54 +0800

  }

}

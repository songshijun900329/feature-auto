package cn.xiaosi.tool.common.utils

import java.text.{ParseException, SimpleDateFormat}
import java.time._
import java.time.format.{DateTimeFormatter, DateTimeParseException, ResolverStyle}
import java.util.{Calendar, Date, Locale, Optional}

object DateUtils {

  def dateToString(date: Date): String = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    format.format(date)
  }

  def dateToLocalDateTime(date: Date): LocalDateTime = LocalDateTime.ofInstant(date.toInstant, ZoneId.systemDefault)

  def dateToLocalDate(date: Date): LocalDate = dateToLocalDateTime(date).toLocalDate

  def localDateToDate(localDate: LocalDate): Date = localDateTimeToDate(localDate.atStartOfDay)

  def localDateToString(localDate: LocalDate): String = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

  def localDateTimeToString(localDateTime: LocalDateTime): String = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

  def localTimeToString(localTime: LocalTime): String = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))

  def stringToLocalDate(time: String): LocalDate = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

  def stringToLocalDateTime(time: String): LocalDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

  def localDateTimeToDate(dateTime: LocalDateTime): Date = Date.from(dateTime.atZone(ZoneId.systemDefault).toInstant)

  def localDateTimeToStamp(localDateTime: LocalDateTime): Long = {
    val zone = ZoneId.systemDefault
    val instant = localDateTime.atZone(zone).toInstant
    instant.toEpochMilli
  }

  def getYearsByStartTime(startTime: String): Integer = {
    val startDate = stringToLocalDate(startTime)
    val currentDate = LocalDate.now
    if (currentDate.isBefore(startDate)) 0
    else startDate.until(currentDate).getYears
  }

  def stampToLocalDateTime(stamp: Long): LocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(stamp), ZoneId.systemDefault)

  def dateToString(date: Date, format: String): String = {
    val format1 = new SimpleDateFormat(format)
    format1.format(date)
  }

  def stringToDate(date: String): Date = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    try format.parse(date)
    catch {
      case var3: ParseException =>
        var3.printStackTrace()
        new Date
    }
  }

  def stringToDate(date: String, format: String): Date = {
    val dateFormat = new SimpleDateFormat(format)
    try dateFormat.parse(date)
    catch {
      case var4: ParseException =>
        var4.printStackTrace()
        new Date
    }
  }

  def stringDateToCalendar(str: String): Calendar = {
    val simpleDateFormat = new SimpleDateFormat
    val calendar = Calendar.getInstance
    try calendar.setTime(simpleDateFormat.parse(str))
    catch {
      case var4: ParseException =>
        var4.printStackTrace()
    }
    calendar
  }

  def calendarToDate(calendar: Calendar, format: String): Date = stringToDate(calendarToStringDate(calendar, format))

  def calendarToStringDate(calendar: Calendar, format: String): String = dateToString(calendar.getTime, format)

  def getAllDaysOfMonth(date: Date): Int = {
    val cal = Calendar.getInstance
    cal.setTime(date)
    cal.getActualMaximum(5)
  }

  def getDays(date: Date): Int = {
    val cal = Calendar.getInstance
    cal.setTime(date)
    cal.get(5)
  }

  def getYears(date: Date): Int = {
    val cal = Calendar.getInstance
    cal.setTime(date)
    cal.get(1)
  }

  def getMonth(date: Date): Int = {
    val cal = Calendar.getInstance
    cal.setTime(date)
    cal.get(2) + 1
  }

  def addMonth(date: Date, n: Int): Date = {
    val cal = Calendar.getInstance
    cal.setTime(date)
    cal.add(2, n)
    cal.getTime
  }

  def addDay(date: Date, n: Int): Date = {
    val cal = Calendar.getInstance
    cal.setTime(date)
    cal.add(5, n)
    cal.getTime
  }

  def stringDateToStamp(stringDate: String): Long = stringToDate(stringDate).getTime

  def stampToStringDate(timeStamp: Long): String = {
    val l = timeStamp
    dateToString(new Date(l))
  }

  def dateBetween(startDate: String, endDate: String): Int = {
    val dateStart = stringToDate(startDate, "yyyy-MM-dd")
    val dateEnd = stringToDate(endDate, "yyyy-MM-dd")
    ((dateEnd.getTime - dateStart.getTime) / 1000L / 60L / 60L / 24L).toInt
  }

  def dateBetweenIncludeToday(startDate: String, endDate: String): Int = dateBetween(startDate, endDate) + 1


  /** ***************************************************************************************************************** */


  /*
  解析格林威治时间
   */
  def getGWFormatTime(gwDateStr: String): String = {
    // change by song 2021-03-03
    if (Optional.ofNullable(gwDateStr).isPresent) {

      try {
        val date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(gwDateStr)
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)
      } catch {
        case ex: Exception => {
          ex.printStackTrace()
        }
      }

    } // if's end
    ""
  }

  /*
  解析时间戳字符串为时间
   */
  def getFormatDateStr(timeStampStr: String): String = {
    val length = timeStampStr.length
    val fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    if (length == 10) {
      fm.format(new Date((timeStampStr + "000").toLong))
    }
    fm.format(new Date(timeStampStr.toLong))
  }

  /*
  获取当前时间，格式为yyyy-MM-dd HH:mm:ss
   */
  def getNowDate(): String = {
    getNowDateTime("yyyy-MM-dd HH:mm:ss")
  }

  def getNowDateTime(formatPattern: String): String = {
    val localDateTime = LocalDateTime.now
    val strFormatDateTime = localDateTime.format(DateTimeFormatter.ofPattern(formatPattern))
    strFormatDateTime
  }

  def transformTimeFormat(time_local: String, sourceFormat: String, aimFormat: String): String = {
    val dateTimeFormatter = DateTimeFormatter.ofPattern(sourceFormat, Locale.US).withResolverStyle(ResolverStyle.STRICT)
    val formatter = DateTimeFormatter.ofPattern(aimFormat, Locale.US).withResolverStyle(ResolverStyle.STRICT)
    var strTime: String = null
    try {
      val date = LocalDateTime.parse(time_local, dateTimeFormatter)
      strTime = date.format(formatter)
    } catch {
      case e: DateTimeParseException =>
        // Throw invalid date message
        System.out.println("Exception was thrown")
        e.printStackTrace()
    }
    strTime
  }


}

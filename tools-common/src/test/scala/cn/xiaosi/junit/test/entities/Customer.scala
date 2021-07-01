package cn.xiaosi.junit.test.entities

import javax.persistence._
import scala.beans.BeanProperty

@Entity
@Table(name = "scala_customer")
class Customer extends {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Integer = _

  @BeanProperty
  var customerName: String = _

  def this(customerName: String) {
    this()
    this.customerName = customerName
  }

  override def toString: String = s"Customer($id,$customerName)"

}

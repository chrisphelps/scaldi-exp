import scaldi.{Module, Injector, Injectable}


object Hello extends App {

  implicit val module = new Module {
    bind [MessageService] to new OfficialMessageService

    binding identifiedBy "greeting.official" to "Welcome"
  }

  val hello = new Hello
  hello.sayGreeting
}

class Hello(implicit inj: Injector) extends Injectable {
  def sayGreeting = {
    val greeter = inject [MessageService]

    println(greeter.getGreetMessage("Chris"))
  }
}

trait MessageService {
  def getGreetMessage(name: String) = "trait"
}

class OfficialMessageService(implicit inj: Injector)
  extends MessageService with Injectable {

  val officialGreeting =
    inject [String] (identified by "greeting.official")

  override def getGreetMessage(name: String) = s"$officialGreeting, $name!"
    //"impl"
}

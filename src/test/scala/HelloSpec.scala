import org.scalatest.{Matchers, FlatSpec}
import scaldi.Module

class HelloSpec extends FlatSpec with Matchers {

  "MessageService" should "return an injected message" in {
    implicit val mocksModule = new Module {
      binding identifiedBy "greeting.official" to "Testing"
    }

    val svc = new OfficialMessageService
    svc.getGreetMessage("Foo") should be ("Testing, Foo!")
  }
}

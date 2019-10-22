package gerritforge

import com.github.barbasa.gatling.git.protocol.GitProtocol
import gerritforge.GerritGitScenario._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

import scala.concurrent.duration._

class GerritGitPushSimulation0 extends Simulation {

  val gitProtocol = GitProtocol()
  val numUsers    = 10
  val feeder = (1 to numUsers) map { idx =>
    Map("refSpec" -> s"gatling-test-repo")
  }

  val gitPush = scenario("Git push to Gerrit")
    .feed(feeder.circular)
    .exec(cloneCommand)
    .exec(pushCommand)

  setUp(
    gitPush.inject(constantConcurrentUsers(numUsers) during (10 seconds))
  ).protocols(gitProtocol)

}

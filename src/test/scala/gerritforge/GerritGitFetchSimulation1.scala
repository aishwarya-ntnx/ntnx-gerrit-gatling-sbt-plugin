package gerritforge

import com.github.barbasa.gatling.git.protocol.GitProtocol
import gerritforge.GerritGitScenario._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

import scala.concurrent.duration._

class GerritGitFetchSimulation1 extends Simulation {

  val gitProtocol = GitProtocol()
  val numUsers    = 10
  val feeder = (1 to numUsers) map { idx =>
    Map("refSpec" -> s"gatling-test-branch")
  }

  val gitFetch = scenario("Git fetch from Gerrit")
    .feed(feeder.circular)
    .exec(cloneCommand)
    .exec(fetchCommand)

  setUp(
    gitFetch.inject(constantConcurrentUsers(numUsers) during (10 seconds))
  ).protocols(gitProtocol)

}

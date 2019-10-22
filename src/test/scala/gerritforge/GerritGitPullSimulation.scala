package gerritforge

import com.github.barbasa.gatling.git.protocol.GitProtocol
import gerritforge.GerritGitScenario._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

import scala.concurrent.duration._

class GerritGitPullSimulation extends Simulation {

  val gitProtocol = GitProtocol()
  val numUsers    = 10
  val feeder = (1 to numUsers) map { idx =>
    Map("refSpec" -> s"master")
  }

  val gitPull = scenario("Git push to Gerrit")
    .feed(feeder.circular)
    .exec(cloneCommand)
    .exec(pullCommand)

  setUp(
    gitPull.inject(constantConcurrentUsers(numUsers) during (10 seconds))
  ).protocols(gitProtocol)

}

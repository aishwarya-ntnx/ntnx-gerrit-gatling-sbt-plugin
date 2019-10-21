package gerritforge

import com.github.barbasa.gatling.git.request.builder.GitRequestBuilder
import com.github.barbasa.gatling.git.{GatlingGitConfiguration, GitRequestSession}
import gerritforge.GerritTestConfig._
import io.gatling.core.Predef._

object GerritGitScenario {

  implicit val gitConfig = GatlingGitConfiguration()

  // git clone ssh://jenkins.svc@gerrit.eng.nutanix.com:29418/main
  val cloneCommand = new GitRequestBuilder(
    GitRequestSession("clone", s"${testConfig.sshUrl}/${testConfig.project}", "${refSpec}")
  )

  /*
  // git clone ssh://jenkins.svc@fetch-gerrit.dyn.nutanix.com:29418/main
  val cloneFromSlaveCommand = new GitRequestBuilder(
    GitRequestSession("clone", s"${testConfig.slaveSshUrl}/${testConfig.project}", "${refSpec}")
  )

  // git checkout euphrates-5.11-stable
  val checkoutCommand = new GitRequestBuilder(
    GitRequestSession("checkout", s"${testConfig.branch}")
  )

  // git clone ssh://jenkins.svc@fetch-gerrit.dyn.nutanix.com:29418/toolbox -b master test-toolbox
  val cloneAndCheckoutCommand = new GitRequestBuilder(
    GitRequestSession("clone", s"${testConfig.slaveSshUrl}/${testConfig.project}", "-b", "${testConfig.branch}", "${testConfig.dir}")
  )

  // git rev-parse HEAD
  val getCurrentRevisionCommand = new GitRequestBuilder(
    GitRequestSession("rev-parse", "HEAD")
  )

  // git pull --rebase

  val pushCommand = new GitRequestBuilder(
    GitRequestSession("push", s"${testConfig.sshUrl}/${testConfig.project}", "${refSpec}")
  )
  */
}

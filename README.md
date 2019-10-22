Gatling's SBT Gerrit Test
=========================

This test suite is built on top of the sample Gatling tests provided by GerritForge.
The goal of this suite is to test common git operations performed by both developers and build pipelines, to validate that the 2019 gerrit update.

This project uses SBT 1, which is available [here](https://www.scala-sbt.org/download.html).

By default, each simulation runs with 10 "users". Each simulation is able to run for a specified amount of time.

Start SBT
---------
From the root (ntnx-gerrit-gatling-tests) directory, run SBT.
```bash
$ sbt
```

Run all simulations
-------------------

```bash
> gatling:test
```

Run a single simulation
-----------------------

```bash
> gatling:testOnly gerritforge.GerritGitCloneSimulation
```

List all tasks
--------------------

```bash
> tasks gatling -v
```

package com.example

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, RunnableGraph, Sink, Source}

object  PracticeSimpleFlows {

  def returnOne:Int = {
    1
  }

  def multiplyBy10(implicit matFromSystem: ActorSystem) = {
    val source = Source(1 to 10)
    val sink = Sink.foreach(println)
    val numberFlow = Flow[Int].map(num => num * 10)

    // connect the Source to the Sink, obtaining a RunnableGraph
    val runnable: RunnableGraph[NotUsed] = source.via(numberFlow).to(sink)

    runnable.run()
  }
}

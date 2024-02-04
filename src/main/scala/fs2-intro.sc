import fs2._

val s: Stream[Pure, Int] = Stream(1, 2, 3)
val s2: Stream[Pure, Int] = Stream.empty
val s3 = Stream.emit(42)
val s4 = Stream.emits(Vector(1, 2, 3))
val s5 = Stream.iterate(1)(_ + 1)
val s6 = Stream.unfold(1)(s => if(s == 5) None else Some((s.toString, s + 1)))
val s7 = Stream.range(1, 15)
val s8 = Stream.constant(42)

s.toList
s2.toList
s3.toList
s4.toList
s4.toVector
s5.take(5).toList
s6.toList
s7.toList
s8.take(1).toList

def lettersIter: Stream[Pure, Char]=  Stream.iterate('a')(_.+(1).toChar).take(26)
lettersIter.toList

def lettersUnfold: Stream[Pure, Char]=  Stream.unfold('a')(s => if(s.toInt > 'z'.toInt) None else Some((s, (s.toInt + 1).toChar)))
lettersUnfold.toList

def myIterate[A](initial: A)(next: A=>A ):Stream[Pure,A]={
  Stream.iterate(initial)(next)
}

myIterate[Char]('a')(s => (s.toInt+1).toChar).take(3).toList
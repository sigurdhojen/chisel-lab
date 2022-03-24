import chisel3._
import chisel3.util._

class CountSevenSeg extends Module {
  val io = IO(new Bundle {
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireInit("b1111111".U(7.W))

  // *** your code starts here
  val tickCount = RegInit(0.U(32.W))
  val count = RegInit(0.U(4.W))
  val tick = tickCount === (50000000-1).U //5000000
  val zero = count === 15.U
  tickCount := tickCount+1.U
  when (tick){
    tickCount := 0.U
    count := count + 1.U
    when (zero){
      count := 0.U
    }
  }

  val dec = Module(new SevenSegDec())

  dec.io.in <> count
  dec.io.out <> sevSeg

  // *** your code ends here

  io.seg := ~sevSeg
  io.an := "b1110".U
}

// generate Verilog
object CountSevenSeg extends App {
  emitVerilog(new CountSevenSeg())
}
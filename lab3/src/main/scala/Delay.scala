import chisel3._
import chisel3.util._

class Delay extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****
  def delay(x: UInt) = RegNext(x)
  res := delay(delay(io.din))

  // ***** your code ends here *****

  io.dout := res
}
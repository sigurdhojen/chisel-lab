import chisel3._
import chisel3.util._
/**
 * Use Mux2 components to build a 4:1 multiplexer
 */

class Mux4 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c = Input(UInt(1.W))
    val d = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val y = Output(UInt(1.W))
  })

  // ***** your code starts here *****

  // create a Mux4 component out of Mux2 components
  // and connect the input and output ports.
  io.y := 1.U
  switch(io.sel){
    is("b00".U){io.y := io.a}
    is("b01".U){io.y := io.b}
    is("b10".U){io.y := io.c}
    is("b11".U){io.y := io.d}
  }


  // ***** your code ends here *****
}
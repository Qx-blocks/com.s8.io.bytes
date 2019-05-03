package com.qx.io.bytes;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * <code>ByteBuffer</code>-based <code>ByteInflow</code>
 * @author pc
 *
 */
public class BufferByteInflow implements ByteInflow {

	private ByteBuffer buffer;
	
	public BufferByteInflow(ByteBuffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public byte getByte() {
		return buffer.get();
	}
	

	@Override
	public int getUInt8() throws IOException {
		return buffer.get() & 0xff;
	}
	
	@Override
	public boolean[] getFlagsBlock() throws IOException {
		boolean[] flags = new boolean[8];
		byte b = buffer.get();
		flags[0] = (b & 0x01) == 0x01;
		flags[1] = (b & 0x02) == 0x02;
		flags[2] = (b & 0x04) == 0x04;
		flags[3] = (b & 0x08) == 0x08;
		flags[4] = (b & 0x10) == 0x10;
		flags[5] = (b & 0x20) == 0x20;
		flags[6] = (b & 0x40) == 0x40;
		flags[7] = (b & 0x80) == 0x80;
		return flags;
	}


	@Override
	public byte[] getByteArray(int length) {
		byte[] bytes = new byte[length];
		buffer.get(bytes);
		return bytes;
	}

	

	@Override
	public int getUInt16() throws IOException {
		
		byte b0 = buffer.get();
		byte b1 = buffer.get();
		return (b1 << 8 & 0xff) | (b0 & 0xff);
	}

	
	@Override
	public short getInt16() {
		return buffer.getShort();
	}
	


	@Override
	public int getUInt31() throws IOException {
		byte[] bytes = getByteArray(4);
		return (int) (
				(bytes[0] & 0x7f) << 24 | 
				(bytes[1] & 0xff) << 16 | 
				(bytes[2] & 0xff) << 8 | 
				(bytes[3] & 0xff));
	}
	
	@Override
	public int getInt32() {
		return buffer.getInt();
	}


	@Override
	public int[] getInt32Array() throws IOException {
		// retrieve length
		int length = getUInt16();

		int[] array = new int[length];
		for(int i=0; i<length; i++) {
			array[i] = buffer.getInt();
		}
		return array;
	}
	
	
	@Override
	public long getInt64() {
		return buffer.getLong();
	}


	@Override
	public long[] getInt64Array() throws IOException {
		// retrieve length
		int length = getUInt16();

		long[] array = new long[length];
		for(int i=0; i<length; i++) {
			array[i] = buffer.getLong();
		}
		return array;
	}
	
	
	@Override
	public float getFloat32() {
		return buffer.getFloat();
	}
	

	@Override
	public float[] getFloat32Array() throws IOException {
		int length = getUInt16();
		float[] array = new float[length];
		for(int i=0; i<length; i++) {
			array[i] = buffer.getFloat();
		}
		return array;
	}
	
	
	@Override
	public double getFloat64() {
		return buffer.getDouble();
	}


	@Override
	public double[] getFloat64Array() throws IOException {
		int length = getUInt16();
		double[] array = new double[length];
		for(int i=0; i<length; i++) {
			array[i] = buffer.getDouble();
		}
		return array;
	}


	/**
	 * Max <code>String</code> length is 65536
	 * @return String
	 * @throws IOException 
	 */
	@Override
	public String getString() throws IOException {

		// read unsigned int
		int length = getUInt16();

		// retrieve all bytes
		byte[] bytes = getByteArray(length);
		return new String(bytes);
	}
	

}

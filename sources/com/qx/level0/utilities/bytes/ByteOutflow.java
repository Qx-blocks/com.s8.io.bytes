package com.qx.level0.utilities.bytes;

import java.io.IOException;


/**
 * 
 * <p>
 * /!\ All array or String lengths are encoded as UInt32 to reflect their
 * maximum possible length in JAVA.
 * </p>
 * 
 * @author pc
 *
 */
public interface ByteOutflow {


	/**
	 * Write bytes array. Auto-feed underlying ByteBuffer as necessary.
	 * @param bytes
	 * @throws IOException
	 */
	public void putByteArray(byte[] bytes) throws IOException;



	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param flags
	 * @throws IOException
	 */
	public void putFlags8(boolean[] flags) throws IOException;


	/**
	 * Hack for js part
	 * 
	 * @param value
	 * @throws IOException
	 */
	public default void putBoolean(boolean value) throws IOException {
		putUInt8(value?((byte) 32):((byte) 33));
	}
	

	/**
	 * Directly put byte
	 * @param b
	 * @throws IOException
	 */
	void putByte(byte b) throws IOException;



	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putUInt8(int value) throws IOException;


	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putUInt16(int value) throws IOException;
	


	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putInt16(short value) throws IOException;



	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putUInt32(int value) throws IOException;


	public void putUInt32Array(int[] array) throws IOException;
	
	
	/**
	 * put Uint32 using extensible mechanism to save bytes
	 * @param value
	 * @throws IOException
	 */
	public void putUInt(int value) throws IOException;
	
	
	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putInt32(int value) throws IOException;

	/**
	 * <p>
	 * /!\ All array or String lengths are encoded as UInt32 to reflect their
	 * maximum possible length in JAVA.
	 * </p>
	 * 
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param array
	 * @throws IOException
	 */
	public void putInt32Array(int[] array) throws IOException;


	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putInt64(long value) throws IOException;


	/**
	 * 
	 * @param array
	 * @throws IOException
	 */
	public void putInt64Array(long[] array) throws IOException;


	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putFloat32(float value) throws IOException;


	/**
	 * 
	 * <p>
	 * /!\ All array or String lengths are encoded as UInt32 to reflect their
	 * maximum possible length in JAVA.
	 * </p>
	 * 
	 * @param array
	 * @throws IOException
	 */
	public void putFloat32Array(float[] array) throws IOException;


	/**
	 * Auto-feed underlying ByteBuffer as necessary.
	 * @param value
	 * @throws IOException
	 */
	public void putFloat64(double value) throws IOException;


	/**
	 * 
	 * <p>
	 * /!\ All array or String lengths are encoded as UInt32 to reflect their
	 * maximum possible length in JAVA.
	 * </p>
	 * 
	 * @param array
	 * @throws IOException
	 */
	public void putFloat64Array(double[] array) throws IOException;


	/**
	 * String is encoded in UTF8.
	 * 
	 * @return String
	 * @throws IOException 
	 */
	public void putString(String str) throws IOException;


}

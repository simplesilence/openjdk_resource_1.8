package org.omg.CosNaming;


/**
* org/omg/CosNaming/BindingListHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-i586-cygwin/jdk8u162/10278/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, December 19, 2017 7:00:04 PM PST
*/


/**
   * List of Bindings.
   */
abstract public class BindingListHelper
{
  private static String  _id = "IDL:omg.org/CosNaming/BindingList:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.CosNaming.Binding[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.CosNaming.Binding[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CosNaming.BindingHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.CosNaming.BindingListHelper.id (), "BindingList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.CosNaming.Binding[] read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.CosNaming.Binding value[] = null;
    int _len0 = istream.read_long ();
    value = new org.omg.CosNaming.Binding[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = org.omg.CosNaming.BindingHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CosNaming.Binding[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      org.omg.CosNaming.BindingHelper.write (ostream, value[_i0]);
  }

}

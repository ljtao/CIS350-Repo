package edu.upenn.cis350.gpx;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;


public class GPXcalculatorTest extends TestCase{
	
	protected void setUp(){
	}
	
	@Test
	public void testTrackNull(){
		GPXcalculator c = new GPXcalculator();
		assertEquals(-1, c.calculateDistanceTraveled(null));
	}
	
	@Test
	public void testEmptyTrack(){
		GPXcalculator c = new GPXcalculator();
		ArrayList<GPXtrkseg> array = new ArrayList<GPXtrkseg>();
		GPXtrk t = new GPXtrk("test", array);
		assertEquals(-1, c.calculateDistanceTraveled(t));
	}
	
	@Test
	public void testNullTrackSegs(){
		double value = 0;
		GPXcalculator c = new GPXcalculator();
		ArrayList<GPXtrkseg> array_ts = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> array_tp = new ArrayList<GPXtrkpt>();
		Date d = new Date();
		GPXtrkpt realpt1 = new GPXtrkpt(-4,-14,d);
		GPXtrkpt realpt2 = new GPXtrkpt(75,140,d);
		array_tp.add(realpt1);
		array_tp.add(realpt2);
		GPXtrkseg ts = new GPXtrkseg(array_tp);
		array_ts.add(ts);
		GPXtrk t = new GPXtrk("test", array_ts);
		value = c.calculateDistanceTraveled(t);
		array_ts.add(null);				
		assertEquals(value, c.calculateDistanceTraveled(t));
	}
	
	@Test
	public void testEmptyTrackSegs(){
		double value = 0;
		GPXcalculator c = new GPXcalculator();
		ArrayList<GPXtrkseg> array_ts = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> array_tp = new ArrayList<GPXtrkpt>();
		Date d = new Date();
		GPXtrkpt realpt1 = new GPXtrkpt(-4,-14,d);
		GPXtrkpt realpt2 = new GPXtrkpt(75,140,d);
		array_tp.add(realpt1);
		array_tp.add(realpt2);
		GPXtrkseg ts1 = new GPXtrkseg(array_tp);
		GPXtrkseg ts2 = new GPXtrkseg(new ArrayList<GPXtrkpt>());
		array_ts.add(ts1);
		GPXtrk t = new GPXtrk("test", array_ts);
		value = c.calculateDistanceTraveled(t);
		array_ts.add(ts2);				
		assertEquals(value, c.calculateDistanceTraveled(t));
	}
	
	@Test
	public void testSinglePtTrackSeg(){
		double value = 0;
		GPXcalculator c = new GPXcalculator();
		ArrayList<GPXtrkseg> array_ts = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> array_tp = new ArrayList<GPXtrkpt>();
		ArrayList<GPXtrkpt> singlearray_tp = new ArrayList<GPXtrkpt>();
		Date d = new Date();
		GPXtrkpt realpt1 = new GPXtrkpt(-4,-14,d);
		GPXtrkpt realpt2 = new GPXtrkpt(75,140,d);
		array_tp.add(realpt1);
		array_tp.add(realpt2);
		singlearray_tp.add(realpt1);
		GPXtrkseg ts1 = new GPXtrkseg(array_tp);
		GPXtrkseg ts2 = new GPXtrkseg(singlearray_tp);
		array_ts.add(ts1);
		GPXtrk t = new GPXtrk("test", array_ts);
		value = c.calculateDistanceTraveled(t);
		array_ts.add(ts2);				
		assertEquals(value, c.calculateDistanceTraveled(t));
	}
	
	@Test
	public void testNullTrackPt(){
		double value = 0;
		GPXcalculator c = new GPXcalculator();
		ArrayList<GPXtrkseg> array_ts = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> array_tp = new ArrayList<GPXtrkpt>();
		ArrayList<GPXtrkpt> nullelemarray_tp = new ArrayList<GPXtrkpt>();
		Date d = new Date();
		GPXtrkpt realpt1 = new GPXtrkpt(-4,-14,d);
		GPXtrkpt realpt2 = new GPXtrkpt(75,140,d);
		array_tp.add(realpt1);
		array_tp.add(realpt2);
		nullelemarray_tp.add(realpt1);
		nullelemarray_tp.add(null);
		GPXtrkseg ts1 = new GPXtrkseg(array_tp);
		GPXtrkseg ts2 = new GPXtrkseg(nullelemarray_tp);
		array_ts.add(ts1);
		GPXtrk t = new GPXtrk("test", array_ts);
		value = c.calculateDistanceTraveled(t);
		array_ts.add(ts2);
		assertEquals(value, c.calculateDistanceTraveled(t));
	}
	
	@Test
	public void testBadTrackPt(){
		double value = 0;
		GPXcalculator c = new GPXcalculator();
		ArrayList<GPXtrkseg> array_ts = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> array_tp = new ArrayList<GPXtrkpt>();
		ArrayList<GPXtrkpt> badarray_tp = new ArrayList<GPXtrkpt>();
		Date d = new Date();
		GPXtrkpt realpt1 = new GPXtrkpt(-4,-14,d);
		GPXtrkpt realpt2 = new GPXtrkpt(75,140,d);
		GPXtrkpt badpt1 = new GPXtrkpt(-124,34,d);
		GPXtrkpt badpt2 = new GPXtrkpt(24,246,d);
		array_tp.add(realpt1);
		array_tp.add(realpt2);
		badarray_tp.add(realpt1);
		badarray_tp.add(badpt1);
		GPXtrkseg ts1 = new GPXtrkseg(array_tp);
		GPXtrkseg ts2 = new GPXtrkseg(badarray_tp);
		array_ts.add(ts1);
		GPXtrk t = new GPXtrk("test", array_ts);
		value = c.calculateDistanceTraveled(t);
		array_ts.add(ts2);
		assertEquals(value, c.calculateDistanceTraveled(t));
		badarray_tp.remove(1);
		badarray_tp.add(badpt2);
		assertEquals(value, c.calculateDistanceTraveled(t));
}

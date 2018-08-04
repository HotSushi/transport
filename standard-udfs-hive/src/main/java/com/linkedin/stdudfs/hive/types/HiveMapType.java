package com.linkedin.stdudfs.hive.types;

import com.linkedin.stdudfs.api.types.StdMapType;
import com.linkedin.stdudfs.api.types.StdType;
import com.linkedin.stdudfs.hive.HiveWrapper;
import org.apache.hadoop.hive.serde2.objectinspector.MapObjectInspector;


public class HiveMapType implements StdMapType {

  final MapObjectInspector _mapObjectInspector;

  public HiveMapType(MapObjectInspector mapObjectInspector) {
    _mapObjectInspector = mapObjectInspector;
  }

  @Override
  public Object underlyingType() {
    return _mapObjectInspector;
  }

  @Override
  public StdType keyType() {
    return HiveWrapper.createStdType(_mapObjectInspector.getMapKeyObjectInspector());
  }

  @Override
  public StdType valueType() {
    return HiveWrapper.createStdType(_mapObjectInspector.getMapValueObjectInspector());
  }
}
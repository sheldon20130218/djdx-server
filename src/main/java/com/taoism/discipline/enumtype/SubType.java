package com.taoism.discipline.enumtype;

public enum SubType {
	
	TYPE_01("1","十种远身行法"),
	TYPE_02("2","十种离口过法"),
	TYPE_03("3","十种除恶想法"),
	TYPE_04("4","十种拔逮根法"),
	TYPE_05("5","十种绝声色法"),
	TYPE_06("6","十种俭爱欲法"),
	TYPE_07("7","十种放翫习法"),
	TYPE_08("8","十种洗垢秽法"),
	TYPE_09("9","十种无昏惑法"),
	TYPE_10("10","十种不淫想法"),
	TYPE_11("11","十种不疑空法"),
	TYPE_12("12","十种平好丑法"),
	TYPE_13("13","十种不邪还法"),
	TYPE_14("14","十种常住无法"),
	TYPE_15("15","十种绝心想法"),
	TYPE_16("16","十种习悉意法"),
	TYPE_17("17","十种善防言法"),
	TYPE_18("18","十种不乱转法"),
	TYPE_19("19","十种不悟念法"),
	TYPE_20("20","十种不彼念法"),
	TYPE_21("21","十种不悠想法"),
	TYPE_22("22","十种无常定法"),
	TYPE_23("23","十种无常的法"),
	TYPE_24("24","十种无常顾法"),
	TYPE_25("25","十种不追怀法"),
	TYPE_26("26","十种无犹豫法"),
	TYPE_27("27","十种忍不可忍法");
	
	private String type;
	
	private String name;
	
	SubType(String type, String name){
		this.type = type;
		this.name = name;
	}
	
	public static String getSubType(String typeCode) {
		String name = null;
		SubType[] values = SubType.values();
		for(SubType subType : values) {
			if(typeCode.equals(subType.getType())) {
				name = subType.getName();
			}
		}
		
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
}

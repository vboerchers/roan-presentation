package scriptlib

class Version {
static private Integer current=2014090601

static void check(Integer compare){
	if (compare >=current) {}
	else Message.warning("Old verion of scriptlib. Reinstall your addon and restart Freeplane.")
}	
}

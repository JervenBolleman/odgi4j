package swiss.sib.swissprot.odgi4j;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(value = @Platform(includepath = { 
		"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/",
		"/home/jbollema/git/odgi/deps/DYNAMIC/include/",
		"/home/jbollema/git/odgi/deps/hopscotch-map/include/",
		"/home/jbollema/git/odgi/deps/sparsepp/sparsepp/",
		"/home/jbollema/git/odgi/deps/flat_hash_map/",
		"/home/jbollema/git/odgi/deps/atomicbitvector/include/",
		"/home/jbollema/git/odgi/include/" }, 
linkpath = "/home/jbollema/git/odgi/lib/",
include = {
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/types.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/iteratee.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/util.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/path_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/mutable_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/mutable_path_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/mutable_path_mutable_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/deletable_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/mutable_path_deletable_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/serializable.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/serializable_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/path_position_handle_graph.hpp",
						"/home/jbollema/git/odgi/deps/libhandlegraph/src/include/handlegraph/trivially_serializable.hpp",
						"/home/jbollema/git/odgi/src/dset64.hpp",
						"/home/jbollema/git/odgi/src/node.hpp", "/home/jbollema/git/odgi/src/dna.hpp",
//						"/home/jbollema/git/odgi/src/hash_map.hpp", "/home/jbollema/git/odgi/src/dynamic_structs.hpp",
						"/home/jbollema/git/odgi/src/dynamic_types.hpp", "/home/jbollema/git/odgi/src/odgi.hpp",
						"/home/jbollema/git/odgi/src/odgi-api.h", }

		, preload = { "jemalloc" }), target = "swiss.sib.swissprot.odgi4j.OdgiLibrary")
public class OdgiLibraryConfig implements InfoMapper {
	public void map(InfoMap infoMap) {
//		infoMap.put(new Info("nid_t").pointerTypes("nid_t"));
//		infoMap.put(new Info("handleggraph::nid_t").pointerTypes("nid_t"));
//		infoMap.put(new Info("handleggraph::handle_t").pointerTypes("handle_t"));
//		infoMap.put(new Info("basic/containers").cppTypes("std::pair"));
		infoMap.put(new Info("edge_t").pointerTypes("HandlePair").define());
		infoMap.put(new Info("std::size_t").cast().valueTypes("long").pointerTypes("SizeTPointer"));
		infoMap.put(new Info("std::hash<handlegraph::handle_t>").pointerTypes("hash_handle_t"));
//		infoMap.put(new Info("std::pair<handlegraph::handle_t,handlegraph::handle_t>").skip());
		infoMap.put(new Info("std::pair<handlegraph::handle_t,handlegraph::handle_t>").pointerTypes("HandlePair").define());
		infoMap.put(new Info("std::pair<handlegraph::step_handle_t,handlegraph::step_handle_t>").pointerTypes("StepHandlePair").define());
		infoMap.put(new Info("std::pair<std::map<uint64_t,std::pair<uint64_t,bool> >,std::map<uint64_t,std::pair<uint64_t,bool> > >").skip());
		infoMap.put(new Info("std::hash<std::tuple<> ><handlegraph::handle_t>").skip());
		infoMap.put(new Info("std::function<handlegraph::nid_t(const nid_t&)>").skip());
		infoMap.put(new Info("std::atomic<odgi::nid_t>").skip());
		infoMap.put(new Info("odgi::hash_set<uint64_t>").skip());
		infoMap.put(new Info("std::atomic_flag").skip());
		infoMap.put(new Info("atomic_flag").skip());
		infoMap.put(new Info(" atomic_flag").skip());
		infoMap.put(new Info("__uint128_t").skip());
		infoMap.put(new Info("Aint").skip());
		infoMap.put(new Info("lockfree::LockFreeHashTable<uint64_t,odgi::graph_t::path_metadata_t*>").skip());
//		infoMap.put(new Info("std::atomic<handlegraph::handle_t>").pointerTypes("atomic_handle_t"));
//		infoMap.put(new Info("std::atomic<uint64_t>").pointerTypes("atomic_uint64_t"));
//		infoMap.put(new Info("std::atomic<bool>").pointerTypes("atomic_bool"));
//		infoMap.put(new Info("std::atomic<handlegraph::path_handle_t>").pointerTypes("atomic_path_handle_t"));
//		infoMap.put(new Info("std::atomic<handlegraph::step_handle_t>").pointerTypes("atomic_step_handle_t"));
	}
}
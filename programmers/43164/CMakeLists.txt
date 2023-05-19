find_package(GTest REQUIRED)

if(WIN32)
    set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)
endif(WIN32)

macro(add_library_target target)
    add_library(${target} STATIC "${target}.cpp")
    target_link_libraries(${target} PRIVATE ${ARGN})
    set_property(TARGET ${target} PROPERTY CXX_STANDARD 17)
endmacro()

macro(add_target_test target)
    string(REPLACE "_test" "" target_name ${target})
    add_executable(${target} "${target}.cpp" "${target_name}.cpp")
    target_link_libraries(${target} PRIVATE GTest::gtest GTest::gtest_main ${ARGN})
    if(MSVC)
        ### Edit and Continue for CMake projects
        target_compile_options(${target} PUBLIC "/Zi")
        target_link_options(${target} PUBLIC "/INCREMENTAL")
    endif()
    gtest_discover_tests(${target})
endmacro()

add_library_target(travel_route)

add_target_test(travel_route_test)

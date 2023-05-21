#pragma once

#include <map>
#include <string>
#include <vector>

/**
 * @brief Depth-first search to find the Eulerian path
 * @param node current node being visited
 * @param adjacency_list adjacency list representing the graph
 * @param path Eulerian path
 */
void DepthFirstSearchEulerianPath(const std::string& node,
                                  std::map<std::string, std::vector<std::string>>& adjacency_list,
                                  std::vector<std::string>& path);

/**
 * @brief Find the Eulerian path
 * @param edges list of vectors represented the edges of the graph
 * @param start starting point of the Eulerian Path
 * @return Eulerian path as a vector of strings
 */
std::vector<std::string> FindEulerianPath(const std::vector<std::vector<std::string>>& edges,
                                          const std::string& start);

package leetcodechallenge;

import java.util.HashMap;
import java.util.Map;

public class May14 {
	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	/** Initialize your data structure here. */
	public May14() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode trieNode = node.children.get(ch);
			if (trieNode == null) {
				trieNode = new TrieNode();
				node.children.put(ch, trieNode);
			}
			node = trieNode;
		}
		node.endOfWord = true;

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode trieNode = node.children.get(ch);
			if (trieNode == null)
				return false;
			node = trieNode;
		}
		return node.endOfWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			TrieNode trieNode = node.children.get(ch);
			if (trieNode == null)
				return false;
			node = trieNode;
		}
		return true;
	}

	public static void main(String[] args) {
		May14 may14 = new May14();
		may14.insert("hello");
		System.out.println(may14.search("hello"));
		System.out.println(may14.search("world"));
	}

}

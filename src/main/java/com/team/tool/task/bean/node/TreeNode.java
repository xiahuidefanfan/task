package com.team.tool.task.bean.node;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.team.tool.task.common.util.ToolUtil;

/**
 * @ClassName: TreeNode.java
 * @Description: 前端树形数据模型
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午4:46:42 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0         前端树形数据模型
 */
public class TreeNode{
	
	 /**
     * 节点id
     */
    private Long id;

    /**
     * 父节点
     */
    private Long pid;

    /**
     * 节点名称
     */
    private String name;
    
    /**
     * 子节点的集合
     */
    private List<TreeNode> children;

    public TreeNode() {
        super();
    }

    public TreeNode(Long id, Long pid) {
        super();
        this.id = id;
        this.pid = pid;
    }

    public static TreeNode createRoot() {
        return new TreeNode(0L, -1L);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

    /**
     * @Description: 构建数据模型
     * @author xiahui
     * @date 2018年11月15日 下午5:03:17
     */
	public static List<? extends TreeNode> buildTree(List<? extends TreeNode> nodes) {
        if (nodes.size() <= 0) {
            return nodes;
        }
        return listToTree(nodes);
    }

	/**
	 * Node转为tree
	 * @param list
	 * @return
	 */
    private static List<? extends TreeNode> listToTree(List<? extends TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            //找到根
            if (ToolUtil.isEmpty(tree.getPid()) || tree.getPid() == 0) {
                treeList.add(tree);
            }
            //找到子
            for (TreeNode treeNode : list) {
                if (ToolUtil.isNotEmpty(treeNode.getPid()) && treeNode.getPid().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<TreeNode>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }

}

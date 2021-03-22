/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jzy.game.tool.db;

import com.jzy.game.engine.util.HttpUtil;
import com.jzy.game.tool.util.Args;
import com.jzy.game.tool.util.Config;
import com.jzy.game.tool.util.ExcelUtil;
import com.jzy.game.tool.util.FileUtil;
import com.jzy.game.tool.util.MongoUtil;
import com.jzy.game.tool.util.StringUtil;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class DBTool extends javax.swing.JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBTool.class);

    /**
     * Creates new form DBTool
     */
    public DBTool() {
        initComponents();
        try {
            init();
        } catch (Exception e) {
            LOGGER.error("初始化异常", e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        db = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        sheetJList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        insertDataBtn = new javax.swing.JButton();
        javaFieldBtn = new javax.swing.JButton();
        clearLogBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        db.setModel(dbComboxBoxModel);

        jScrollPane1.setViewportView(sheetJList);

        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        jScrollPane2.setViewportView(logTextArea);

        insertDataBtn.setText("导入数据");
        insertDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDataBtnActionPerformed(evt);
            }
        });

        javaFieldBtn.setText("Java字段");
        javaFieldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaFieldBtnActionPerformed(evt);
            }
        });

        clearLogBtn.setText("清空面板");
        clearLogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLogBtnActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("文件");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("打开");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("退出");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("帮助");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("关于");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(db, 0, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(javaFieldBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(clearLogBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(db, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insertDataBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(javaFieldBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearLogBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertDataBtnActionPerformed
        List<String> selectSheets = sheetJList.getSelectedValuesList();
        if (selectSheets == null || selectSheets.size() < 1) {
            logTextArea.append("请选择表单\r\n");
            return;
        }
        //更新数据库配置
        selectSheets.forEach(sheetName -> {
            try {
                String log = MongoUtil.insertConfigData(getMongoClient(), sheetNameFiles.get(sheetName).getAbsolutePath(), sheetName, getDBConfig().getDbName());
                logTextArea.append(log + "\r\n");
            } catch (Exception e) {
                LOGGER.error("更新数据", e);
            }
        });
        if(mongoClient!=null){
            mongoClient.close();
        }
        //加载服务器配置
       // String loadConfigUrl = getDBConfig().getLoadConfigUrl();
        List<String> loadConfigUrls = getDBConfig().getLoadConfigUrls();
        for (String loadConfigUrl:loadConfigUrls){
            if(loadConfigUrl!=null&&!loadConfigUrl.equalsIgnoreCase("")){
                String log = HttpUtil.URLGet(loadConfigUrl);
                logTextArea.append("游戏服-"+getDBConfig().getDbName()+" "+loadConfigUrl+":"+log+"更新配置成功\r\n");
            }
        }
    }//GEN-LAST:event_insertDataBtnActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "联系：359135103", "JiangZhiYong", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        if(file!=null){
            setSheetList(file.getAbsolutePath());
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void javaFieldBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaFieldBtnActionPerformed
        //显示对应表的Java字段定义
        List<String> selectSheets = sheetJList.getSelectedValuesList();
        if (selectSheets == null || selectSheets.size() < 1) {
            logTextArea.append("请选择表单\r\n");
            return;
        }
        selectSheets.forEach(sheetName -> {
            try {
                Args.Four<List<String>, List<String>, List<String>,List<String>> metaData = ExcelUtil.getMetaData(sheetNameFiles.get(sheetName).getAbsolutePath(), sheetName);
                for(int i=0;i<metaData.a().size();i++){
                    //不显示客户端字段
                    if("client".equalsIgnoreCase(metaData.d().get(i))){
                        continue;
                    }
                    StringBuilder sb=new StringBuilder();
                    sb.append("/**").append(metaData.c().get(i)).append("*/").append("\r\n");
                    sb.append("private ");
                    String filedType = metaData.b().get(i).toLowerCase();
                    if("string".equals(filedType)||"date".equals(filedType)||"object".equals(filedType)){   //首字母大写
                        filedType=StringUtil.upFirstChar(filedType);
                    }else if("array".equals(filedType)){
                        filedType="List<Object>";
                    }
                    sb.append(filedType).append(" ").append(metaData.a().get(i)).append(";");
                    logTextArea.append(sb.toString() + "\r\n");
                }
                 logTextArea.append("\r\n");
            } catch (Exception e) {
                LOGGER.error("更新数据", e);
            }
        });
        if (mongoClient!=null){
            mongoClient.close();
        }

    }//GEN-LAST:event_javaFieldBtnActionPerformed

    private void clearLogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLogBtnActionPerformed
       this.logTextArea.setText("");
    }//GEN-LAST:event_clearLogBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DBTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBTool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton clearLogBtn;
    private javax.swing.JComboBox<String> db;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton insertDataBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton javaFieldBtn;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JList<String> sheetJList;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="自定义逻辑">
    private String configPath;    //配置路径
    private String projectPath;    //项目路径
    public DefaultComboBoxModel dbComboxBoxModel = new DefaultComboBoxModel();
    private Map<String, File> sheetNameFiles = new HashMap<>();
    private static MongoClient mongoClient; //数据库客户端
    private static Config config;

    /**
     * 自定义初始化
     */
    private void init() throws Exception {
        config = FileUtil.getConfigXML(getConfigPath(), "config.xml", Config.class);
        if (config == null) {
            LOGGER.error("配置文件{}不存在", config);
            System.exit(1);
        }
        //设置数据名称
        config.getDbs().forEach(db -> dbComboxBoxModel.addElement(db.getName()));

        //设置表单列表
        if (config.getExcelDir() == null || "".equals(config.getExcelDir().trim())) {
            config.setExcelDir(projectPath);
        }
        setSheetList(config.getExcelDir());
    }

    /**
     * 设置表单显示列表
     *
     * @param filePath
     */
    public void setSheetList(String filePath) {
        List<File> excelFiles = new ArrayList<>();
        FileUtil.getFiles(filePath, excelFiles, ExcelUtil.xls,null);
        FileUtil.getFiles(filePath, excelFiles, ExcelUtil.xlsx,null);
        Vector sheetNames = new Vector();
        sheetNameFiles.clear();
        sheetJList.removeAll();
        excelFiles.forEach(file -> {
            String absolutePath = file.getAbsolutePath();
            try {
                List<String> sheets = ExcelUtil.getSheetNames(absolutePath);
                if (sheets != null) {
                    sheets.stream().filter(it->it.startsWith("config")).forEach(name -> {
                        sheetNameFiles.put(name, file);
                        sheetNames.add(name);
                    });
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(DBTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        if (sheetNames.size() > 0) {
            Collections.sort(sheetNames);
            sheetJList.setListData(sheetNames);
        } else {
            logTextArea.append("未找到默认表，\r\n");
        }
    }

    /**
     * 获取路径
     *
     * @return
     */
    public String getConfigPath() {
        if (configPath == null) {
            File file = new File(System.getProperty("user.dir"));
            if ("target".equals(file.getName())||file.getAbsolutePath().contains("DBTool")) {
                configPath = file.getPath() + File.separatorChar + "config";
            } else {
                configPath = file.getPath() + File.separatorChar + "target" + File.separatorChar + "config";
            }
            LOGGER.warn("配置路径为：" + configPath);
        }
        return configPath;
    }

    /**
     * 获取路径
     *
     * @return
     */
    public String getProjectPath() {
        if (projectPath == null) {
            File file = new File(System.getProperty("user.dir"));
            if ("target".equals(file.getName())) {
                projectPath = file.getPath();
            } else {
                projectPath = file.getPath() + File.separatorChar + "target";
            }
            LOGGER.warn("项目路径为：" + projectPath);
        }
        return projectPath;
    }

    /**
     * 获取连接
     *
     * @return
     */
    public MongoClient getMongoClient() {
        MongoClientURI connectionString = new MongoClientURI(getDBConfig().getUrl());
        mongoClient = new MongoClient(connectionString);
        return mongoClient;
    }

    public Config.DBConfig getDBConfig() {
        Optional<Config.DBConfig> findAny = config.getDbs().stream().filter(dbConfig -> dbConfig.getName().equals((String) db.getSelectedItem())).findAny();
        if (findAny.isPresent()) {
            return findAny.get();
        }
        return null;
    }

    //</editor-fold>
}

package cn.boqi.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//启动游戏
public class StartTheGame {
    public static boolean flag=false;//控制是否继续
    public static boolean twoFlag=false;//控制是否继续

    //P1玩家棋子移动方法
    public static synchronized void oneMovePiece(HashMap<Integer, Integer> P1Map, HashMap<Integer, Integer> P2Map, int mark) {
        Integer i = P1Map.get(mark);
        int oneCount = 0;
        int twoCount = 0;
        int sum;
        sum = P1Map.get(mark);
        //清空自己的分数
        P1Map.put(mark, 0);
        for (int j = 1; j <= i; j++) {
            //超过7的界限后往P2阵容+1
            if (mark + j > 7) {
                oneCount++;
                //修改2号玩家棋子
                P2Map.put(oneCount, P2Map.get(oneCount) + 1);
                flag=false;//继续本次
            } else {
                twoCount++;
                //修改P1往后移动+1
                P1Map.put(mark + j, P1Map.get(mark + j) + 1);
                if ((mark + j) == 7) {
                    flag = false;//继续本次
                } else {
                    flag = true;//终止本次
                    twoFlag = false;//进入P2回合
                    //判断碰撞条件 如 P1 6[1]而 P2 1[4] 碰撞后取自得到5 并累计到 总积分中
                    if ((mark + j) < 7) {
                        if (P1Map.get(mark + twoCount) == 1) {
                            if (mark + twoCount == 6 && twoCount - sum == 0) {
                                P1Map.put(7, P2Map.get(1) + P1Map.get(mark + twoCount) + P1Map.get(7));
                                P1Map.put(mark + twoCount, 0);
                                P2Map.put(1, 0);
                            } else if (mark + twoCount == 5 && twoCount - sum == 0) {
                                P1Map.put(7, P2Map.get(2) + P1Map.get(mark + twoCount) + P1Map.get(7));
                                P1Map.put(mark + twoCount, 0);
                                P2Map.put(1, 0);
                            } else if (mark + twoCount == 4 && twoCount - sum == 0) {
                                P1Map.put(7, P2Map.get(3) + P1Map.get(mark + twoCount) + P1Map.get(7));
                                P1Map.put(mark + twoCount, 0);
                                P2Map.put(1, 0);
                            } else if (mark + twoCount == 3 && twoCount - sum == 0) {
                                P1Map.put(7, P2Map.get(4) + P1Map.get(mark + twoCount) + P1Map.get(7));
                                P1Map.put(mark + twoCount, 0);
                                P2Map.put(1, 0);
                            } else if (mark + twoCount == 2 && twoCount - sum == 0) {
                                P1Map.put(7, P2Map.get(5) + P1Map.get(mark + twoCount) + P1Map.get(7));
                                P1Map.put(mark + twoCount, 0);
                                P2Map.put(1, 0);
                            } else if (mark + twoCount == 1 && twoCount - sum == 0) {
                                P1Map.put(7, P2Map.get(6) + P1Map.get(mark + twoCount) + P1Map.get(7));
                                P1Map.put(mark + twoCount, 0);
                                P2Map.put(1, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    //P2玩家棋子移动方法
    public static synchronized void twoMovePiece(HashMap<Integer, Integer> P1Map, HashMap<Integer, Integer> P2Map, int mark) {
        Integer i = P2Map.get(mark);
        int oneCount = 0;//
        int twoCount = 0;//
        int sum;
        sum = P2Map.get(mark);
        //清空自己的分数
        P2Map.put(mark, 0);
        for (int j = 1; j <= i; j++) {
            if (mark + j > 7) {
                oneCount++;
                //修改2号玩家棋子
                P1Map.put(oneCount, P1Map.get(oneCount) + 1);
                twoFlag = false;
            } else {
                twoCount++;
                P2Map.put(mark + j, P2Map.get(mark + j) + 1);
                if ((mark + j) == 7) {
                    twoFlag = false;//继续本次
                } else {
                twoFlag = true;//结束本次
                flag = false;//进入P1回合
                //判断碰撞条件 如 P1 6[1]而 P2 1[4] 碰撞后取自得到5 并累计到 总积分中
                if ((mark + j) < 7) {
                    if (P2Map.get(mark + twoCount) == 1) {
                        if (mark + twoCount == 6 && twoCount - sum == 0) {
                            P2Map.put(7, P2Map.get(1) + P2Map.get(mark + twoCount) + P2Map.get(7));
                            P2Map.put(mark + twoCount, 0);
                            P1Map.put(1, 0);
                        } else if (mark + twoCount == 5 && twoCount - sum == 0) {
                            P2Map.put(7, P2Map.get(2) + P2Map.get(mark + twoCount) + P2Map.get(7));
                            P2Map.put(mark + twoCount, 0);
                            P1Map.put(1, 0);
                        } else if (mark + twoCount == 4 && twoCount - sum == 0) {
                            P2Map.put(7, P2Map.get(3) + P2Map.get(mark + twoCount) + P2Map.get(7));
                            P2Map.put(mark + twoCount, 0);
                            P1Map.put(1, 0);
                        } else if (mark + twoCount == 3 && twoCount - sum == 0) {
                            P2Map.put(7, P2Map.get(4) + P2Map.get(mark + twoCount) + P2Map.get(7));
                            P2Map.put(mark + twoCount, 0);
                            P1Map.put(1, 0);
                        } else if (mark + twoCount == 2 && twoCount - sum == 0) {
                            P2Map.put(7, P2Map.get(5) + P2Map.get(mark + twoCount) + P2Map.get(7));
                            P2Map.put(mark + twoCount, 0);
                            P1Map.put(1, 0);
                        } else if (mark + twoCount == 1 && twoCount - sum == 0) {
                            P2Map.put(7, P2Map.get(6) + P2Map.get(mark + twoCount) + P2Map.get(7));
                            P2Map.put(mark + twoCount, 0);
                            P1Map.put(1, 0);
                        }
                    }
                }
            }
        }
        }
    }
    //判断棋子只要一方的棋盘的子没了则游戏结束
    public static synchronized void gameEnd(HashMap<Integer, Integer> P1Map, HashMap<Integer, Integer> P2Map){
        int p1Piece=0;
        int p2Piece=0;
        //获取双方阵营分数
        for (int i = 1; i <=6 ; i++) {
            p1Piece+=P1Map.get(i);
            p2Piece+=P2Map.get(i);
        }
        //游戏结束时 做出的判断  如 P1阵营子全部取完  则未取完的棋子在对方棋盘 则归对方所有
        if(p1Piece==0){
            Integer i = P2Map.get(7);
            P2Map.put(7,i+p2Piece);
            System.out.println("+--------------------------------------------------------+");
            System.out.println("| P1    | 6[" + P1Map.get(6) + "] | 5[" + P1Map.get(5) + "] | 4[" + P1Map.get(4) + "] | 3[" + P1Map.get(3) + "] | 2[" + P1Map.get(2) + "] | 1[" + P1Map.get(1) + "] |  " + P2Map.get(7) + "   |");
            System.out.println("|       |-----------------------------------------|      |");
            System.out.println("| " + P1Map.get(7) + "     | 1[" + P2Map.get(1) + "] | 2[" + P2Map.get(2) + "] | 3[" + P2Map.get(3) + "] | 4[" + P2Map.get(4) + "] | 5[" + P2Map.get(5) + "] | 6[" + P2Map.get(6) + "] |  P2  |");
            System.out.println("+--------------------------------------------------------+");

            System.out.println("P1手中棋子为:"+P1Map.get(7));
            System.out.println("P2手中棋子为:"+P2Map.get(7));
            if(P1Map.get(7)>P2Map.get(7)) {
                System.out.println("P1赢了");
            }
            System.exit(0);
        }
        //游戏结束时 做出的判断  如 P1阵营子全部取完  则未取完的棋子在对方棋盘 则归对方所有
        if(p2Piece==0){
            Integer i = P1Map.get(7);
            P1Map.put(7,i+p1Piece);
            System.out.println("+--------------------------------------------------------+");
            System.out.println("| P1    | 6[" + P1Map.get(6) + "] | 5[" + P1Map.get(5) + "] | 4[" + P1Map.get(4) + "] | 3[" + P1Map.get(3) + "] | 2[" + P1Map.get(2) + "] | 1[" + P1Map.get(1) + "] |  " + P2Map.get(7) + "   |");
            System.out.println("|       |-----------------------------------------|      |");
            System.out.println("| " + P1Map.get(7) + "     | 1[" + P2Map.get(1) + "] | 2[" + P2Map.get(2) + "] | 3[" + P2Map.get(3) + "] | 4[" + P2Map.get(4) + "] | 5[" + P2Map.get(5) + "] | 6[" + P2Map.get(6) + "] |  P2  |");
            System.out.println("+--------------------------------------------------------+");

            System.out.println("P1手中棋子为:"+P1Map.get(7));
            System.out.println("P2手中棋子为:"+P2Map.get(7));
            if(P2Map.get(7)>P1Map.get(7)) {
                System.out.println("P2赢了");
            }
            System.exit(0);

        }


    }
    //游戏循环方法
    public static void play() {
        //P1阵容
        HashMap<Integer, Integer> P1Map = new HashMap<>();
        P1Map.put(1, 4);
        P1Map.put(2, 4);
        P1Map.put(3, 4);
        P1Map.put(4, 4);
        P1Map.put(5, 4);
        P1Map.put(6, 1);
        P1Map.put(7, 0);
        //P2阵容
        HashMap<Integer, Integer> P2Map = new HashMap<>();
        P2Map.put(1, 4);
        P2Map.put(2, 4);
        P2Map.put(3, 4);
        P2Map.put(4, 4);
        P2Map.put(5, 4);
        P2Map.put(6, 4);
        P2Map.put(7, 0);
        //键盘录入 控制输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到播棋游戏");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| P1    | 6[" + P1Map.get(6) + "] | 5[" + P1Map.get(5) + "] | 4[" + P1Map.get(4) + "] | 3[" + P1Map.get(3) + "] | 2[" + P1Map.get(2) + "] | 1[" + P1Map.get(1) + "] |  " + P2Map.get(7) + "   |");
        System.out.println("|       |-----------------------------------------|      |");
        System.out.println("| " + P1Map.get(7) + "     | 1[" + P2Map.get(1) + "] | 2[" + P2Map.get(2) + "] | 3[" + P2Map.get(3) + "] | 4[" + P2Map.get(4) + "] | 5[" + P2Map.get(5) + "] | 6[" + P2Map.get(6) + "] |  P2  |");
        System.out.println("+--------------------------------------------------------+");
        gameEnd(P1Map,P2Map);
        //无限循环 直至游戏结束
        while(true) {
            while (flag == false) {
                System.out.print("P1选手,你选择出(输入7可跳过):");
                int select = scanner.nextInt();
                if (P1Map.get(select) != 0) {
                    switch (select) {
                        case 9:
                            flag=true;
                            break;
                        case 8:
                            flag=true;
                            break;
                        case 7:
                            flag=true;
                            break;
                        default:
                            oneMovePiece(P1Map, P2Map, select);
                            System.out.println("+--------------------------------------------------------+");
                            System.out.println("| P1    | 6[" + P1Map.get(6) + "] | 5[" + P1Map.get(5) + "] | 4[" + P1Map.get(4) + "] | 3[" + P1Map.get(3) + "] | 2[" + P1Map.get(2) + "] | 1[" + P1Map.get(1) + "] |  " + P2Map.get(7) + "   |");
                            System.out.println("|       |-----------------------------------------|      |");
                            System.out.println("| " + P1Map.get(7) + "     | 1[" + P2Map.get(1) + "] | 2[" + P2Map.get(2) + "] | 3[" + P2Map.get(3) + "] | 4[" + P2Map.get(4) + "] | 5[" + P2Map.get(5) + "] | 6[" + P2Map.get(6) + "] |  P2  |");
                            System.out.println("+--------------------------------------------------------+");
                            gameEnd(P1Map, P2Map);
                            break;
                    }
                } else {
                    System.out.println("不能选择空棋子");
                    break;
                }
            }
            while (twoFlag == false) {
                System.out.print("P2选手,你选择出(输入7可跳过):");

                int twoSelect = scanner.nextInt();
                if (P2Map.get(twoSelect) != 0) {
                    switch (twoSelect) {
                        case 9:
                            twoFlag=true;
                            break;
                        case 8:
                            twoFlag=true;
                            break;
                        case 7:
                            twoFlag=true
                            ;
                            break;
                        default:
                            twoMovePiece(P1Map, P2Map, twoSelect);
                            System.out.println("+--------------------------------------------------------+");
                            System.out.println("| P1    | 6[" + P1Map.get(6) + "] | 5[" + P1Map.get(5) + "] | 4[" + P1Map.get(4) + "] | 3[" + P1Map.get(3) + "] | 2[" + P1Map.get(2) + "] | 1[" + P1Map.get(1) + "] |  " + P2Map.get(7) + "   |");
                            System.out.println("|       |-----------------------------------------|      |");
                            System.out.println("| " + P1Map.get(7) + "     | 1[" + P2Map.get(1) + "] | 2[" + P2Map.get(2) + "] | 3[" + P2Map.get(3) + "] | 4[" + P2Map.get(4) + "] | 5[" + P2Map.get(5) + "] | 6[" + P2Map.get(6) + "] |  P2  |");
                            System.out.println("+--------------------------------------------------------+");
                            gameEnd(P1Map, P2Map);

                            break;
                    }
                } else {
                    System.out.println("不能选择空棋子");
                    break;
                }
            }
        }



    }
    public static void main(String[] args) {
        //调用方法启动
        play();
    }
}

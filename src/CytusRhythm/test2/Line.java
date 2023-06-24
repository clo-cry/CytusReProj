package CytusRhythm.test2;

import java.awt.*;

public class Line {
    int x = 670;
    int y = 100;
    int endx = 800;
    int endy = 800;

    double length = 200;//线长
    double n = 0;
    //n达到边界反向
    int dir = 1;
    //状态 0摇摆，1抓取，2收回,3抓取返回
    int state;
    //抓取判定
    HJKG frame;

    Line(HJKG frame) {
        this.frame = frame;
    }

    void logic() {
        for (Object obj : this.frame.objectList) {
            if (endx > obj.x && endx < obj.x + obj.width
                    && endy > obj.y && endy < obj.y + obj.height) {
                state = 3;
                obj.flag = true;
            }

        }
    }

    void paintSelf(Graphics g) {
        logic();

        switch (state) {
            case 0:
                if (n < 0.2) {
                    dir = 1;
                } else if (n > 0.8) {
                    dir = -1;
                }
                n = n + 0.005 * dir;
                endx = (int) (x + length * Math.cos(n * Math.PI));
                endy = (int) (y + length * Math.sin(n * Math.PI));
                g.drawLine(x, y, endx, endy);
                break;
            case 1:
                if (length < 500) {
                    length = length + 10;
                    endx = (int) (x + length * Math.cos(n * Math.PI));
                    endy = (int) (y + length * Math.sin(n * Math.PI));
                    g.drawLine(x, y, endx, endy);

                } else {
                    state = 2;
                }
                break;
            case 2:
                if (length > 100) {
                    length = length - 10;
                    endx = (int) (x + length * Math.cos(n * Math.PI));
                    endy = (int) (y + length * Math.sin(n * Math.PI));
                    g.drawLine(x, y, endx, endy);
                } else {
                    state = 0;
                }
                break;
            case 3:
                if (length > 100) {
                    length = length - 10;
                    endx = (int) (x + length * Math.cos(n * Math.PI));
                    endy = (int) (y + length * Math.sin(n * Math.PI));
                    g.drawLine(x, y, endx, endy);
                    for (Object obj : this.frame.objectList) {
                        if (obj.flag) {
                            obj.x = endx - 26;
                            obj.y = endy;
                            if (length <= 100) {
                                obj.x = -150;
                                obj.y = -150;
                                obj.flag = false;
                                state = 0;
                            }
                        }

                    }
                    break;


                }
        }
    }
}
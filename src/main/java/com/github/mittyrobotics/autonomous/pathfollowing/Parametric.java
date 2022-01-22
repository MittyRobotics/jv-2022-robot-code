package com.github.mittyrobotics.autonomous.pathfollowing;

public class Parametric {
    /**
     * Length of the parametric
     */
    protected double length;

    /**
     * Returns the {@link Point2D} at t
     * @param t t to get associated {@link Point2D}
     * @return {@link Point2D} at t
     */
    public Point2D getPoint(double t) {
        return new Point2D();
    }

    /**
     * Returns the {@link Angle} at t
     * @param t t to get associated {@link Angle}
     * @return {@link Angle} at t
     */
    public Angle getAngle(double t) {
        return new Angle();
    }

    /**
     * Returns the total length of the parametric
     * @return the total length of the parametric
     */
    public double getLength() {
        return length;
    }

    /**
     * Returns the {@link Pose2D} at t
     * @param t t to get associated {@link Pose2D}
     * @return {@link Pose2D} at t
     */
    public Pose2D getPose(double t) {
        return new Pose2D();
    }

    /**
     * Returns the nth derivative as a {@link Point2D} at t
     * @param t t to get associated nth derivative
     * @param n degree of the derivative
     * @return the nth derivative as a {@link Point2D} at t
     */
    public Point2D getDerivative(double t, int n) {
        return new Point2D();
    }

    /**
     * Returns an array of the nth Legendre-Gauss coefficients
     * @param n degree of the coefficients
     * @return double array of the nth Legendre-Gauss coefficients
     */
    public double[][] getCoefficients(int n) {
        //Source: https://pomax.github.io/bezierinfo/legendre-gauss.html
        switch (n) {
            case 2:
                return new double[][] {
                        {1.0000000000000000, -0.577350269189626},
                        {1.0000000000000000, 0.577350269189626}
                };
            case 3:
                return new double[][] {
                        {0.888888888888889, 0.0000000000000000},
                        {0.555555555555556, -0.774596669241483},
                        {0.555555555555556, 0.774596669241483}
                };
            case 4:
                return new double[][] {
                        {0.652145154862546, -0.339981043584856},
                        {0.652145154862546, 0.339981043584856},
                        {0.347854845137454, -0.861136311594053},
                        {0.347854845137454, 0.861136311594053}
                };
            case 5:
                return new double[][] {
                        {0.568888888888889, 0.0000000000000000},
                        {0.478628670499367, -0.538469310105683},
                        {0.478628670499367, 0.538469310105683},
                        {0.236926885056189, -0.9061798459386640},
                        {0.236926885056189, 0.9061798459386640},
                };
            case 6:
                return new double[][] {
                        {0.360761573048139, 0.661209386466265},
                        {0.360761573048139, -0.661209386466265},
                        {0.4679139345726910, -0.238619186083197},
                        {0.4679139345726910, 0.238619186083197},
                        {0.17132449237917, -0.932469514203152},
                        {0.17132449237917, 0.932469514203152}
                };
            case 7:
                return new double[][] {
                        {0.417959183673469, 0.0000000000000000},
                        {0.381830050505119, 0.405845151377397},
                        {0.381830050505119, -0.405845151377397},
                        {0.279705391489277, -0.741531185599395},
                        {0.279705391489277, 0.741531185599395},
                        {0.12948496616887, -0.949107912342759},
                        {0.12948496616887, 0.949107912342759}
                };
            case 8:
                return new double[][] {
                        {0.3626837833783620, -0.18343464249565},
                        {0.3626837833783620, 0.18343464249565},
                        {0.313706645877887, -0.5255324099163290},
                        {0.313706645877887, 0.5255324099163290},
                        {0.222381034453375, -0.796666477413627},
                        {0.222381034453375, 0.796666477413627},
                        {0.101228536290376, -0.960289856497536},
                        {0.101228536290376, 0.960289856497536}
                };
            case 9:
                return new double[][] {
                        {0.33023935500126, 0.0000000000000000},
                        {0.180648160694857, -0.836031107326636},
                        {0.180648160694857, 0.836031107326636},
                        {0.0812743883615744, -0.968160239507626},
                        {0.0812743883615744, 0.968160239507626},
                        {0.312347077040003, -0.324253423403809},
                        {0.312347077040003, 0.324253423403809},
                        {0.260610696402935, -0.61337143270059},
                        {0.260610696402935, 0.61337143270059}
                };
            case 10:
                return new double[][] {
                        {0.295524224714753, -0.148874338981631},
                        {0.295524224714753, 0.148874338981631},
                        {0.269266719309996, -0.433395394129247},
                        {0.269266719309996, 0.433395394129247},
                        {0.2190863625159820, -0.679409568299024},
                        {0.2190863625159820, 0.679409568299024},
                        {0.149451349150581, -0.865063366688985},
                        {0.149451349150581, 0.865063366688985},
                        {0.0666713443086881, -0.973906528517172},
                        {0.0666713443086881, 0.973906528517172}
                };
            case 11:
                return new double[][] {
                        {0.272925086777901, 0.0000000000000000},
                        {0.262804544510247, -0.2695431559523450},
                        {0.262804544510247, 0.2695431559523450},
                        {0.233193764591991, -0.519096129206812},
                        {0.233193764591991, 0.519096129206812},
                        {0.186290210927734, -0.730152005574049},
                        {0.186290210927734, 0.730152005574049},
                        {0.125580369464905, -0.887062599768095},
                        {0.125580369464905, 0.887062599768095},
                        {0.0556685671161737, -0.9782286581460570},
                        {0.0556685671161737, 0.9782286581460570}
                };
            case 12:
                return new double[][] {
                        {0.249147045813403, -0.125233408511469},
                        {0.249147045813403, 0.125233408511469},
                        {0.233492536538355, -0.36783149899818},
                        {0.233492536538355, 0.36783149899818},
                        {0.203167426723066, -0.587317954286618},
                        {0.203167426723066, 0.587317954286618},
                        {0.160078328543346, -0.769902674194305},
                        {0.160078328543346, 0.769902674194305},
                        {0.106939325995318, -0.904117256370475},
                        {0.106939325995318, 0.904117256370475},
                        {0.0471753363865118, -0.981560634246719},
                        {0.0471753363865118, 0.981560634246719}
                };
            case 13:
                return new double[][] {
                        {0.232551553230874, 0.0000000000000000},
                        {0.226283180262897, -0.230458315955135},
                        {0.226283180262897, 0.230458315955135},
                        {0.207816047536889, -0.448492751036447},
                        {0.207816047536889, 0.448492751036447},
                        {0.178145980761946, -0.64234933944034},
                        {0.178145980761946, 0.64234933944034},
                        {0.138873510219787, -0.80157809073331},
                        {0.138873510219787, 0.80157809073331},
                        {0.0921214998377285, -0.917598399222978},
                        {0.0921214998377285, 0.917598399222978},
                        {0.0404840047653159, -0.984183054718588},
                        {0.0404840047653159, 0.984183054718588}
                };
            case 14:
                return new double[][] {
                        {0.215263853463158, -0.108054948707344},
                        {0.215263853463158, 0.108054948707344},
                        {0.205198463721296, -0.31911236892789},
                        {0.205198463721296, 0.31911236892789},
                        {0.185538397477938, -0.515248636358154},
                        {0.185538397477938, 0.515248636358154},
                        {0.157203167158194, -0.687292904811686},
                        {0.157203167158194, 0.687292904811686},
                        {0.121518570687903, -0.8272013150697650},
                        {0.121518570687903, 0.8272013150697650},
                        {0.0801580871597602, -0.928434883663574},
                        {0.0801580871597602, 0.928434883663574},
                        {0.0351194603317519, -0.986283808696812},
                        {0.0351194603317519, 0.986283808696812}
                };
            case 15:
                return new double[][] {
                        {0.202578241925561, 0.0000000000000000},
                        {0.198431485327112, -0.201194093997435},
                        {0.198431485327112, 0.201194093997435},
                        {0.186161000015562, -0.394151347077563},
                        {0.186161000015562, 0.394151347077563},
                        {0.166269205816994, -0.570972172608539},
                        {0.166269205816994, 0.570972172608539},
                        {0.139570677926154, -0.72441773136017},
                        {0.139570677926154, 0.72441773136017},
                        {0.107159220467172, -0.848206583410427},
                        {0.107159220467172, 0.848206583410427},
                        {0.0703660474881081, -0.9372733924007060},
                        {0.0703660474881081, 0.9372733924007060},
                        {0.0307532419961173, -0.987992518020485},
                        {0.0307532419961173, 0.987992518020485}
                };
            case 16:
                return new double[][] {
                        {0.189450610455069, -0.0950125098376374},
                        {0.189450610455069, 0.0950125098376374},
                        {0.182603415044924, -0.281603550779259},
                        {0.182603415044924, 0.281603550779259},
                        {0.169156519395003, -0.458016777657227},
                        {0.169156519395003, 0.458016777657227},
                        {0.149595988816577, -0.617876244402644},
                        {0.149595988816577, 0.617876244402644},
                        {0.124628971255534, -0.7554044083550030},
                        {0.124628971255534, 0.7554044083550030},
                        {0.0951585116824928, -0.865631202387832},
                        {0.0951585116824928, 0.865631202387832},
                        {0.0622535239386479, -0.944575023073233},
                        {0.0622535239386479, 0.944575023073233},
                        {0.0271524594117541, -0.98940093499165},
                        {0.0271524594117541, 0.98940093499165}
                };
            case 17:
                return new double[][] {
                        {0.179446470356207, 0.0000000000000000},
                        {0.176562705366993, -0.178484181495848},
                        {0.176562705366993, 0.178484181495848},
                        {0.1680041021564500, -0.351231763453876},
                        {0.1680041021564500, 0.351231763453876},
                        {0.15404576107681, -0.512690537086477},
                        {0.15404576107681, 0.512690537086477},
                        {0.135136368468526, -0.657671159216691},
                        {0.135136368468526, 0.657671159216691},
                        {0.1118838471934040, -0.781514003896801},
                        {0.1118838471934040, 0.781514003896801},
                        {0.0850361483171792, -0.880239153726986},
                        {0.0850361483171792, 0.880239153726986},
                        {0.0554595293739872, -0.950675521768768},
                        {0.0554595293739872, 0.950675521768768},
                        {0.0241483028685479, -0.990575475314417},
                        {0.0241483028685479, 0.990575475314417}
                };
            case 18:
                return new double[][] {
                        {0.169142382963144, -0.0847750130417353},
                        {0.169142382963144, 0.0847750130417353},
                        {0.164276483745833, -0.251886225691506},
                        {0.164276483745833, 0.251886225691506},
                        {0.154684675126265, -0.411751161462843},
                        {0.154684675126265, 0.411751161462843},
                        {0.140642914670651, -0.559770831073948},
                        {0.140642914670651, 0.559770831073948},
                        {0.122555206711479, -0.691687043060353},
                        {0.122555206711479, 0.691687043060353},
                        {0.100942044106287, -0.803704958972523},
                        {0.100942044106287, 0.803704958972523},
                        {0.0764257302548891, -0.892602466497556},
                        {0.0764257302548891, 0.892602466497556},
                        {0.0497145488949698, -0.955823949571398},
                        {0.0497145488949698, 0.955823949571398},
                        {0.0216160135264833, -0.991565168420931},
                        {0.0216160135264833, 0.991565168420931}
                };
            case 19:
                return new double[][] {
                        {0.161054449848784, 0.0000000000000000},
                        {0.158968843393954, -0.160358645640225},
                        {0.158968843393954, 0.160358645640225},
                        {0.15276604206586, -0.31656409996363},
                        {0.15276604206586, 0.31656409996363},
                        {0.142606702173607, -0.464570741375961},
                        {0.142606702173607, 0.464570741375961},
                        {0.128753962539336, -0.6005453046616810},
                        {0.128753962539336, 0.6005453046616810},
                        {0.1115666455473340, -0.720966177335229},
                        {0.1115666455473340, 0.720966177335229},
                        {0.0914900216224500, -0.822714656537143},
                        {0.0914900216224500, 0.822714656537143},
                        {0.0690445427376412, -0.903155903614818},
                        {0.0690445427376412, 0.903155903614818},
                        {0.0448142267656996, -0.9602081521348300},
                        {0.0448142267656996, 0.9602081521348300},
                        {0.0194617882297265, -0.992406843843584},
                        {0.0194617882297265, 0.992406843843584}
                };
            case 20:
                return new double[][] {
                        {0.152753387130726, -0.0765265211334973},
                        {0.152753387130726, 0.0765265211334973},
                        {0.149172986472604, -0.227785851141645},
                        {0.149172986472604, 0.227785851141645},
                        {0.1420961093183820, -0.37370608871542},
                        {0.1420961093183820, 0.37370608871542},
                        {0.131688638449177, -0.510867001950827},
                        {0.131688638449177, 0.510867001950827},
                        {0.118194531961518, -0.6360536807265150},
                        {0.118194531961518, 0.6360536807265150},
                        {0.10193011981724, -0.746331906460151},
                        {0.10193011981724, 0.746331906460151},
                        {0.0832767415767048, -0.839116971822219},
                        {0.0832767415767048, 0.839116971822219},
                        {0.0626720483341091, -0.912234428251326},
                        {0.0626720483341091, 0.912234428251326},
                        {0.0406014298003869, -0.963971927277914},
                        {0.0406014298003869, 0.963971927277914},
                        {0.0176140071391521, -0.993128599185095},
                        {0.0176140071391521, 0.993128599185095}
                };
        };
        return new double[][]{};
    }

    /**
     *
     * @param start
     * @param end
     * @param steps
     * @return
     */
    public double getGaussianQuadratureLength(double start, double end, int steps) {
        //first row are weights, second row are points
        double[][] coefficients = getCoefficients(steps);

        //we are trying to find integral of sqrt(x'(t)^2 + y'(t)^2) from 0 to 1

        //integral bound transformation from [0,1] to [-1, 1]
        double half = (end - start) / 2.0;
        double avg = (start + end) / 2.0;
        double length = 0;
        for (int i = 0; i < coefficients.length; i++) {
            //sqrt(x'(t)^2 + y'(t)^2)
            length += getDerivative(avg + half * coefficients[i][1], 1).magnitude() * coefficients[i][0];
        }
        return length * half;
    }

    public double getGaussianQuadratureLength(double end, int steps) {
        return getGaussianQuadratureLength(0, end, steps);
    }

    public double getGaussianQuadratureLength(int steps) {
        return getGaussianQuadratureLength(1.0, steps);
    }

    public double getAccelerationMagnitudeFromCurvature(double curvature, double velocityMagnitude) {
        //a_rad = |V|^2 / R, curvature = 1/R
        return curvature * velocityMagnitude * velocityMagnitude;
    }

    public double getCurvature(double t) {
        Point2D d1 = getDerivative(t, 1);
        Point2D d2 = getDerivative(t, 2);

        //https://en.wikipedia.org/wiki/Curvature#In_terms_of_a_general_parametrization
        return (d1.getX() * d2.getY() - d2.getX() * d1.getY()) / Math.pow(d1.getX()*d1.getX() + d1.getY()*d1.getY(), 1.5);
    }

    public double getRawLength(double start, double end, double steps) {
        double stepSize = (end - start) / steps;
        double length = 0;

        for(double i = start; i <= end; i += stepSize) {
            length += getPoint(i).distance(getPoint(i+stepSize));
        }

        return length;
    }


    //get closest point using Newton's method on each of several initial points defined by steps, goes through a certain number of iterations or until threshold is reached
    public double findClosestPointOnSpline(Point2D point, double threshold, int steps, int iterations) {

        Vector2D cur_min = new Vector2D(Double.POSITIVE_INFINITY, 0);

        for(double i = 0; i <= 1; i += 1./steps) {
            double cur_t = i;
            Vector2D derivs = getDerivsAtT(cur_t, point);
            double dt = derivs.getX() / derivs.getY();

            int counter = 0;

            while(Math.abs(dt) >= threshold && counter < iterations) {
                cur_t -= dt;
                derivs = getDerivsAtT(cur_t, point);
                dt = derivs.getX() / derivs.getY();
                counter++;
            }

            if(counter < iterations) {
                double cur_d = getDistanceAtT(cur_t, point);

                if(cur_d < cur_min.getX()) {
                    cur_min = new Vector2D(cur_d, cur_t);
                }
            }
        }

        return Math.min(1, Math.max(0, cur_min.getY()));

    }

    //first and second derivative of distance from point to spline at that t
    public Vector2D getDerivsAtT(double t, Point2D point) {
        Point2D p = getPoint(t);
        Point2D d1 = getDerivative(t, 1);
        Point2D d2 = getDerivative(t, 2);

        double x_a = p.getX() - point.getX();
        double y_b = p.getY() - point.getY();

        return new Vector2D(
                2*(x_a*d1.getX() + y_b*d1.getY()),
                2*(d1.getX() * d1.getX() + x_a*d2.getX() + d1.getY() * d1.getY() + y_b * d2.getY())
        );
    }

    //distance from point to spline at that t
    public double getDistanceAtT(double t, Point2D point) {
        Point2D p = getPoint(t);
        return (p.getX() - point.getX())*(p.getX() - point.getX()) +
                (p.getY() - point.getY())*(p.getY() - point.getY());
    }

    public double getTFromLength(double length) {
        double t = length / this.length;

        for(int i = 0; i < 5; i++) {
            double tangentMagnitude = getDerivative(t, 1).magnitude();
            if(tangentMagnitude > 0.0) {
                t -= (getGaussianQuadratureLength(t, 11) - length) / tangentMagnitude;
                t = Math.min(1, Math.max(t, 0));
            }
        }

        return t;
    }

    public Vector2D getAbsoluteMaxCoordinates(double steps) {
        Vector2D max = new Vector2D();

        double stepsize = 1/steps;
        for(double t = 0; t <= 1; t += stepsize) {
            Point2D point = getPoint(t);
            max.x = Math.max(max.x, Math.abs(point.getX()));
            max.y = Math.max(max.y, Math.abs(point.getY()));
        }

        return max;
    }

    public Parametric getNewPath(Pose2D newPos, Vector2D newVel, Vector2D newAcc) {
        if(this instanceof QuinticHermiteSpline) {
            if(newVel.getMagnitude() == 0) {
                return new QuinticHermiteSpline(newPos, ((QuinticHermiteSpline) this).getPose1());
            }
            return new QuinticHermiteSpline(newPos, ((QuinticHermiteSpline) this).getPose1(), newVel,
                    ((QuinticHermiteSpline) this).getVelocity1(), newAcc, ((QuinticHermiteSpline) this).getAcceleration1());
        }
        return new Parametric();
    }

}

# JAVA_HOME="/usr/java/jdk"
JAVA_HOME="/C/Program Files/Java/jdk1.8.0_45"
APP_HOME=$(pwd)
LIB_HOME="$APP_HOME"/lib
CONF_HOME="$APP_HOME"/conf
MAIN_CLASS=com.cyb.spring.boot.mybatis.app.Application
JAVA_OPTS="-server -Xmx1G -Xms1G -Xmn300M"

CLASSPATH="$LIB_HOME":"$CONF_HOME"
for jar in "$LIB_HOME"/*.jar; do
	CLASSPATH="$CLASSPATH":"$jar"
done

pid=0

getpid() {
	javaps=$("$JAVA_HOME"/bin/jps -l | grep $MAIN_CLASS)

	if [ -n "$javaps" ]; then
		pid=$(echo $javaps | awk '{print $1}')
	else
		pid=0
	fi
}

start() {
	getpid

	if [ $pid -ne 0 ]; then
		echo "$MAIN_CLASS already started! (pid=$pid)"
	else
		echo -n "Starting $MAIN_CLASS ..."
		# JAVA_CMD="nohup $JAVA_HOME/bin/java $JAVA_OPTS -cp $CLASSPATH $MAIN_CLASS > /dev/null 2>&1 &"
		# su - $USER -c "$JAVA_CMD"
		nohup "$JAVA_HOME"/bin/java $JAVA_OPTS -cp $CLASSPATH $MAIN_CLASS > /dev/null 2>&1 &
		getpid
		if [ $pid -ne 0 ]; then
			echo "(pid=$pid)  [OK]"
		else
			echo "[Failed]"
		fi
	fi
}

stop() {
	getpid

	if [ $pid -ne 0 ]; then
		echo -n "Stopping $MAIN_CLASS ... (pid=$pid) "
		# su - $USER -c "kill -9 $pid"
		kill -9 $pid
		if [ $? -eq 0 ]; then
			echo [OK]
		else
			echo [Failed]
		fi

		getpid
		if [ $pid -ne 0 ]; then
			stop
		fi
	else
		echo "$MAIN_CLASS is not running"
	fi
}

status() {
	getpid

	if [ $pid -ne 0 ]; then
		echo "$MAIN_CLASS is running! (pid=$pid)"
	else
		echo "$MAIN_CLASS is not running"
	fi
}

case "$1" in
	'start')
		start
		;;
	'stop')
		stop
		;;
	'restart')
		stop
		start
		;;
	'status')
		status
		;;
	*)
		echo "Usage: $0 {start|stop|restart|status}"
		exit 1
esac

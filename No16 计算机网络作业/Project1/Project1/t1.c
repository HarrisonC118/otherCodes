#include<stdio.h>
typedef enum { frame_arrival } event_type;
//protocol.h
#define MAX_PKT 1024
typedef enum { true, false } boolean;
typedef unsigned int seq_nr;
typedef struct { unsigned char data[MAX_PKT]; } packet;
typedef enum { data, ack, nak } frame_kind;
typedef struct {
	frame_kind kind;
	seq_nr seq;
	seq_nr ack;
	packet info;
} frame;
void wait_for_event(event_type* event);
void from_network_layer(packet* p) {
	printf("网络层封装数据包\n");
}
void to_network_layer(packet* p) {
	printf("数据包到网络层\n");
}
void from_physical_layer(frame* r) {
	printf("数据帧到物理层\n");
}
void to_physical_layer(frame* s) {
	printf("物理层传输数据帧\n");
}
void start_timer(seq_nr k);
void stop_timer(seq_nr k);
void start_ack_timer(void);
void stop_ack_timer(void);
void enable_network_layer(void);
void disable_network_layer(void);
#define inc(k) if (k < MAX_SEQ) k = k + 1; else k = 0
void sender1(void)
{
	frame s;
	packet buffer;
	while (true) {
		from_network_layer(&buffer);
		s.info = buffer;
		to_physical_layer(&s);
	}
}
void receiver1(void)
{
	frame r;
	event_type event;
	while (true) {
		wait_for_event(&event);
		from_physical_layer(&r);
		to_network_layer(&r.info);
	}
}
int main() {
	sender1();
	receiver1();
	return 0;
}